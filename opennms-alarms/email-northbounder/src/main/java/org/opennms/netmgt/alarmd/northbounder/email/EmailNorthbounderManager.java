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
package org.opennms.netmgt.alarmd.northbounder.email;

import java.util.HashMap;
import java.util.Map;

import org.opennms.core.soa.Registration;
import org.opennms.core.soa.ServiceRegistry;
import org.opennms.netmgt.alarmd.api.NorthboundAlarm;
import org.opennms.netmgt.alarmd.api.Northbounder;
import org.opennms.netmgt.alarmd.api.NorthbounderException;
import org.opennms.netmgt.dao.api.JavaMailConfigurationDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * The Class EmailNorthbounderManager.
 * 
 * @author <a href="mailto:agalue@opennms.org">Alejandro Galue</a>
 */
public class EmailNorthbounderManager implements InitializingBean, Northbounder, DisposableBean {

    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(EmailNorthbounderManager.class);

    /** The service registry. */
    @Autowired
    private ServiceRegistry m_serviceRegistry;

    /** The Email northbounder configuration DAO. */
    @Autowired
    private EmailNorthbounderConfigDao m_configDao;

    /** The JavaMail configuration DAO. */
    @Autowired
    private JavaMailConfigurationDao m_javaMailDao;

    /** The registrations map. */
    private Map<String, Registration> m_registrations = new HashMap<String, Registration>();

    /**
     * After properties set.
     *
     * @throws Exception the exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(m_configDao);
        Assert.notNull(m_serviceRegistry);

        // Registering itself as a northbounder
        m_registrations.put(getName(), m_serviceRegistry.register(this, Northbounder.class));

        // Registering each destination as a northbounder
        registerNorthbounders();
    }

    /**
     * Register northbounders.
     *
     * @throws Exception the exception
     */
    private void registerNorthbounders() throws Exception {
        if (! m_configDao.getConfig().isEnabled()) {
            LOG.warn("The Email NBI is globally disabled, the destinations won't be registered which means all the alarms will be rejected.");
            return;
        }
        for (EmailDestination destination : m_configDao.getConfig().getEmailDestinations()) {
            LOG.info("Registering Email northbound configuration for destination {}.", destination.getName());
            EmailNorthbounder nbi = new EmailNorthbounder(m_configDao, m_javaMailDao, destination.getName());
            nbi.afterPropertiesSet();
            m_registrations.put(nbi.getName(), m_serviceRegistry.register(nbi, Northbounder.class));
        }
    }

    /**
     * Destroy.
     *
     * @throws Exception the exception
     */
    @Override
    public void destroy() throws Exception {
        m_registrations.values().forEach(Registration::unregister);
    }

    /**
     * Start.
     *
     * @throws NorthbounderException the northbounder exception
     */
    @Override
    public void start() throws NorthbounderException {
        // There is no need to do something here. Only the reload method will be implemented
    }

    @Override
    public boolean isReady() {
        return false;
    }

    /**
     * On alarm.
     *
     * @param alarm the alarm
     * @throws NorthbounderException the northbounder exception
     */
    @Override
    public void onAlarm(NorthboundAlarm alarm) throws NorthbounderException {
        // There is no need to do something here. Only the reload method will be implemented
    }

    /**
     * Stop.
     *
     * @throws NorthbounderException the northbounder exception
     */
    @Override
    public void stop() throws NorthbounderException {
        // There is no need to do something here. Only the reload method will be implemented
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    @Override
    public String getName() {
        return EmailNorthbounder.NBI_NAME;
    }

    /**
     * Reloads the configuration.
     */
    @Override
    public void reloadConfig() {
        LOG.info("Reloading Email northbound configuration.");
        try {
            m_configDao.reload();
            m_javaMailDao.reloadConfiguration();
            m_registrations.forEach((k,v) -> { if (k != getName()) v.unregister();});
            registerNorthbounders();
        } catch (Exception e) {
            throw new NorthbounderException("Can't reload the SNMP trap northbound configuration", e);
        }
    }

}