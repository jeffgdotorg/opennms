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
package org.opennms.web.admin.nodeManagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.opennms.core.db.DataSourceFactory;
import org.opennms.core.utils.DBUtils;
import org.opennms.core.utils.WebSecurityUtils;

/**
 * A servlet that handles querying the database for node, interface, service
 * combinations
 *
 * @author <A HREF="mailto:jamesz@opennms.com">James Zuo </A>
 * @author <A HREF="http://www.opennms.org/">OpenNMS </A>
 */
public class GetInterfacesServlet extends HttpServlet {
    private static final long serialVersionUID = 6768576652872631928L;

    private static final String INTERFACE_QUERY = "SELECT ipaddr, isManaged FROM ipinterface " + "WHERE nodeid=? " + "AND ismanaged IN ('M','A','U','F') " + "AND ipaddr <> '0.0.0.0' " + "ORDER BY inet(ipaddr)";

    private static final String SERVICE_QUERY = "SELECT ifservices.serviceid, service.servicename, ifservices.status FROM ifservices, service, ipInterface, node WHERE ifServices.ipInterfaceId = ipInterface.id AND ipInterface.nodeId = node.nodeId AND node.nodeid = ? AND ipInterface.ipaddr = ? AND ifservices.status in ('A','U','F','S','R') AND ifservices.serviceid = service.serviceid ORDER BY service.servicename";

    /** {@inheritDoc} */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int nodeId = -1;
        String nodeIdString = request.getParameter("node");

        if (nodeIdString == null)
            throw new ServletException("Missing node Id.");

        HttpSession user = request.getSession(true);

        try {
            nodeId = WebSecurityUtils.safeParseInt(nodeIdString);
        } catch (NumberFormatException numE) {
            throw new ServletException(numE.getMessage());
        }

        if (nodeId < 0)
            throw new ServletException("Invalid node ID.");

        try {
            user.setAttribute("interfaces.nodemanagement", getInterfaces(user, nodeId));
        } catch (SQLException sqlE) {
            throw new ServletException(sqlE);
        } catch (IllegalStateException illE) {
            throw new ServletException(illE);
        }

        // forward the request for proper display
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/admin/nodemanagement/managenode.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * <p>
     * Retrieve all the interfaces and services from the database, and keep them
     * in the user session.
     * 
     * @param userSession
     *            Current user working session
     * @param nodeId
     *            Id of the node to manage
     */
    private List<ManagedInterface> getInterfaces(HttpSession userSession, int nodeId) throws SQLException {
        Connection connection = null;
        List<ManagedInterface> allInterfaces = new ArrayList<>();
        int lineCount = 0;

        final DBUtils d = new DBUtils(getClass());
        try {
            connection = DataSourceFactory.getInstance().getConnection();
            d.watch(connection);

            PreparedStatement ifaceStmt = connection.prepareStatement(INTERFACE_QUERY);
            d.watch(ifaceStmt);
            ifaceStmt.setInt(1, nodeId);

            ResultSet ifaceResults = ifaceStmt.executeQuery();
            d.watch(ifaceResults);
            while (ifaceResults.next()) {
                lineCount++;
                ManagedInterface newInterface = new ManagedInterface();
                newInterface.setNodeid(nodeId);
                newInterface.setAddress(ifaceResults.getString(1));
                newInterface.setStatus(ifaceResults.getString(2));
                allInterfaces.add(newInterface);

                PreparedStatement svcStmt = connection.prepareStatement(SERVICE_QUERY);
                d.watch(svcStmt);
                svcStmt.setInt(1, nodeId);
                svcStmt.setString(2, newInterface.getAddress());

                ResultSet svcResults = svcStmt.executeQuery();
                d.watch(svcResults);
                while (svcResults.next()) {
                    lineCount++;
                    ManagedService newService = new ManagedService();
                    newService.setId(svcResults.getInt(1));
                    newService.setName(svcResults.getString(2));
                    newService.setStatus(svcResults.getString(3));
                    newInterface.addService(newService);
                }
            }
            userSession.setAttribute("lineItems.nodemanagement", Integer.valueOf(lineCount));
        } finally {
            d.cleanUp();
        }
        return allInterfaces;
    }
}
