/*
 * Licensed to The OpenNMS Group, Inc (TOG) under one or more
 * contributor license agreements.  See the LICENSE.md file
 * distributed with this work for additional information
 * regarding copyright ownership.
 *
 * TOG licenses this file to You under the GNU Affero General
 * Public License Version 3 (the "License") or (at your option)
 * any later version.  You may not use this file except in
 * compliance with the License.  You may obtain a copy of the
 * License at:
 *
 *      https://www.gnu.org/licenses/agpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.  See the License for the specific
 * language governing permissions and limitations under the
 * License.
 */
package org.opennms.protocols.nsclient.monitor;

import java.net.InetAddress;
import java.util.Map;

import org.opennms.core.utils.InetAddressUtils;
import org.opennms.core.utils.ParameterMap;
import org.opennms.core.utils.TimeoutTracker;
import org.opennms.netmgt.poller.MonitoredService;
import org.opennms.netmgt.poller.PollStatus;
import org.opennms.netmgt.poller.support.AbstractServiceMonitor;
import org.opennms.protocols.nsclient.NSClientAgentConfig;
import org.opennms.protocols.nsclient.NsclientCheckParams;
import org.opennms.protocols.nsclient.NsclientException;
import org.opennms.protocols.nsclient.NsclientManager;
import org.opennms.protocols.nsclient.NsclientPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is designed to be used by the service poller framework to test
 * the availability of a generic TCP service on remote interfaces. The class
 * implements the ServiceMonitor interface that allows it to be used along
 * with other plug-ins by the service poller framework.
 *
 * @author <A HREF="mailto:matt.raykowski@gmail.com">Matt Raykowski</A>
 */
public class NsclientMonitor extends AbstractServiceMonitor {
	
	private static final Logger LOG = LoggerFactory.getLogger(NsclientMonitor.class);

    /**
     * Default retries.
     */
    private static final int DEFAULT_RETRY = 0;

    /**
     * Default timeout. Specifies how long (in milliseconds) to block waiting
     * for data from the monitored interface.
     */
    private static final int DEFAULT_TIMEOUT = 3000;

    /**
     * {@inheritDoc}
     *
     * Poll the specified address for service availability. During the poll an
     * attempt is made to connect on the specified port. If the connection
     * request is successful, the parameters are parsed and turned into
     * <code>NsclientCheckParams</code> and a check is performed against the
     * remote NSClient service. If the <code>NsclientManager</code> responds
     * with a <code>NsclientPacket</code> containing a result code of
     * <code>NsclientPacket.RES_STATE_OK</code> then we have determined that
     * we are talking to a valid service and we set the service status to
     * SERVICE_AVAILABLE and return.
     */
    @Override
    public PollStatus poll(MonitoredService svc, Map<String, Object> parameters) {
        // Holds the response reason.
        String reason = null;
        // Used to exit the retry loop early, if possible.
        int serviceStatus = PollStatus.SERVICE_UNRESPONSIVE;
        // This will hold the data the server sends back.
        NsclientPacket response = null;
        // Used to track how long the request took.
        Double responseTime = null;

        // NSClient related parameters.
        String command = ParameterMap.getKeyedString(
                                                     parameters,
                                                     "command",
                                                     NsclientManager.convertTypeToString(NsclientManager.CHECK_CLIENTVERSION));
        int port = ParameterMap.getKeyedInteger(parameters, "port",
                                                NsclientManager.DEFAULT_PORT);
        
        String password = ParameterMap.getKeyedString(parameters, "password", NSClientAgentConfig.DEFAULT_PASSWORD);
        String params = ParameterMap.getKeyedString(parameters, "parameter",
                                                    null);
        int critPerc = ParameterMap.getKeyedInteger(parameters,
                                                    "criticalPercent", 0);
        int warnPerc = ParameterMap.getKeyedInteger(parameters,
                                                    "warningPercent", 0);

        TimeoutTracker tracker = new TimeoutTracker(parameters, DEFAULT_RETRY, DEFAULT_TIMEOUT);


        // Get the address we're going to poll.
        InetAddress ipAddr = svc.getAddress();

        for (tracker.reset(); tracker.shouldRetry() && serviceStatus != PollStatus.SERVICE_AVAILABLE; tracker.nextAttempt()) {
            try {
                
                tracker.startAttempt();

                // Create a client, set up details and connect.
                NsclientManager client = new NsclientManager(InetAddressUtils.str(ipAddr),
                                                             port, password);
                client.setTimeout(tracker.getSoTimeout());
                client.setPassword(password);
                client.init();

                // Set up the parameters the client will use to validate the
                // response.
                NsclientCheckParams clientParams = new NsclientCheckParams(
                                                                           critPerc,
                                                                           warnPerc,
                                                                           params);

                // Send the request to the server and receive the response.
                response = client.processCheckCommand(
                                                      NsclientManager.convertStringToType(command),
                                                      clientParams);
                // Now save the time it took to process the check command.
                responseTime = tracker.elapsedTimeInMillis();

                if (response == null) {
                    continue;
                }

                if (response.getResultCode() == NsclientPacket.RES_STATE_OK) {
                    serviceStatus = PollStatus.SERVICE_AVAILABLE;
                    reason = response.getResponse();
                } else if (response.getResultCode() == NsclientPacket.RES_STATE_CRIT) {
                    serviceStatus = PollStatus.SERVICE_UNAVAILABLE;
                    reason = response.getResponse();
                    // set this to null so we don't try to save data when the node is down
                    responseTime = null;
                }

            } catch (NsclientException e) {
                LOG.debug("Nsclient Poller received exception from client", e);
                reason = "NsclientException: " + e.getMessage();
            }
        } // end for(;;)
        return PollStatus.get(serviceStatus, reason, responseTime);

    }
}
