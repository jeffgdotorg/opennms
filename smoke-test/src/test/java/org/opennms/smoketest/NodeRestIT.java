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
package org.opennms.smoketest;

import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.is;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.core.Response;

import org.junit.ClassRule;
import org.junit.Test;
import org.opennms.core.utils.InetAddressUtils;
import org.opennms.netmgt.model.OnmsIpInterface;
import org.opennms.netmgt.model.OnmsMonitoredService;
import org.opennms.netmgt.model.OnmsNode;
import org.opennms.netmgt.model.OnmsServiceType;
import org.opennms.smoketest.stacks.OpenNMSStack;
import org.opennms.smoketest.utils.RestClient;

/**
 * This test verifies creation/deletion of Nodes/Interfaces/Services through
 * Rest API
 */
public class NodeRestIT {

    @ClassRule
    public static OpenNMSStack stack = OpenNMSStack.MINIMAL;

    @Test
    public void testRestCallsOnNodesInterfacesAndServices() {
        RestClient restClient = stack.opennms().getRestClient();

        // Create a node
        OnmsNode node = new OnmsNode();
        node.setLabel("node1");
        node.setType(OnmsNode.NodeType.ACTIVE);
        // Set foreignSource and foreignId to use it as nodeCriteria
        node.setForeignSource("test");
        node.setForeignId("node1");
        // Verify that node was added
        Response response = restClient.addNode(node);
        assertEquals(201, response.getStatus());
        node = restClient.getNode("test:node1");
        assertEquals("node1", node.getLabel());
        // Add Interface to node
        OnmsIpInterface ipInterface = new OnmsIpInterface();
        ipInterface.setNode(node);
        ipInterface.setIpAddress(InetAddressUtils.getInetAddress("192.168.1.1"));
        ipInterface.setIpHostName("192.168.1.1");
        // Verify that interface (192.168.1.1) was added
        response = restClient.addInterface("test:node1", ipInterface);
        assertEquals(201, response.getStatus());
        // Add another Interface to node
        OnmsIpInterface ipInterface2 = new OnmsIpInterface();
        ipInterface2.setNode(node);
        ipInterface2.setIpAddress(InetAddressUtils.getInetAddress("192.168.1.2"));
        ipInterface2.setIpHostName("192.168.1.2");
        // Verify that interface2 (192.168.1.2) was added
        response = restClient.addInterface("test:node1", ipInterface2);
        assertEquals(201, response.getStatus());
        ipInterface2 = restClient.getInterface("test:node1", "192.168.1.2");
        assertEquals(node.getId(), ipInterface2.getNode().getId());
        assertEquals("192.168.1.2", ipInterface2.getIpHostName());
        // Delete interface (192.168.1.2), (asynchronous call, response will be 202)
        response = restClient.deleteInterface("test:node1", "192.168.1.2");
        assertEquals(202, response.getStatus());
        // Verify that interface2 (192.168.1.2) was deleted
        // Since delete is asynchronous call, wait till Interface is deleted
        await().atMost(30, TimeUnit.SECONDS).pollInterval(5, TimeUnit.SECONDS)
                .until(() -> restClient.getResponseForInterface("test:node1", "192.168.1.2").getStatus(), is(404));
        // Add services on interface (192.168.1.1)
        OnmsMonitoredService service = new OnmsMonitoredService();
        OnmsServiceType serviceType = new OnmsServiceType();
        serviceType.setName("HTTP");
        service.setServiceType(serviceType);
        // Verify that service http was added 
        response = restClient.addService("test:node1", "192.168.1.1", service);
        assertEquals(201, response.getStatus());
        // Add another service on interface (192.168.1.1)
        OnmsMonitoredService service2 = new OnmsMonitoredService();
        OnmsServiceType serviceType2 = new OnmsServiceType();
        serviceType2.setName("SSH");
        service2.setServiceType(serviceType2);
        // Verify that service https was added 
        response = restClient.addService("test:node1", "192.168.1.1", service2);
        assertEquals(201, response.getStatus());
        // Delete http service (asynchronous call, response will be 202)
        response = restClient.deleteService("test:node1", "192.168.1.1", "HTTP");
        assertEquals(202, response.getStatus());
        // Delete https service (asynchronous call, response will be 202)
        response = restClient.deleteService("test:node1", "192.168.1.1", "SSH");
        assertEquals(202, response.getStatus());
        // Verify that interface (192.168.1.1) was deleted since all services are deleted
        // Since node also doesn't exist, responde code will be 400
        await().atMost(30, TimeUnit.SECONDS).pollInterval(5, TimeUnit.SECONDS)
                .until(() -> restClient.getResponseForInterface("test:node1", "192.168.1.1").getStatus(), is(400));
        // Verify that node is also deleted
        response = restClient.getResponseForNode("test:node1");
        assertEquals(404, response.getStatus());
    }

}
