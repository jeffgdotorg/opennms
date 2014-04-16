<%--
/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2006-2012 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2012 The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * OpenNMS(R) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with OpenNMS(R).  If not, see:
 *      http://www.gnu.org/licenses/
 *
 * For more information contact:
 *     OpenNMS(R) Licensing <license@opennms.org>
 *     http://www.opennms.org/
 *     http://www.opennms.com/
 *******************************************************************************/

--%>

<%-- 
  This page is included by other JSPs to create a box containing a tree of 
  service level availability information for the interfaces and services of
  a given node.
  
  It expects that a <base> tag has been set in the including page
  that directs all URLs to be relative to the servlet context.
--%>

<%@page language="java"
        contentType="text/html"
        session="true"
        import="org.opennms.core.utils.WebSecurityUtils,
                org.opennms.web.category.CategoryModel,
                org.opennms.web.category.CategoryUtil,
                org.opennms.web.element.ElementUtil,
                org.opennms.web.element.Interface,
                org.opennms.web.element.NetworkElementFactory,
                org.opennms.web.element.Service"
        %>
<%@ page import="org.opennms.web.servlet.MissingParameterException" %>
<%@ page import="java.util.Date" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%!
    private CategoryModel m_model;

    private double m_normalThreshold;
    private double m_warningThreshold;

    public void init() throws ServletException {
        try {
            m_model = CategoryModel.getInstance();
        } catch (Throwable e) {
            throw new ServletException("Could not instantiate the CategoryModel: " + e, e);
        }

        m_normalThreshold = m_model.getCategoryNormalThreshold(CategoryModel.OVERALL_AVAILABILITY_CATEGORY);
        m_warningThreshold = m_model.getCategoryWarningThreshold(CategoryModel.OVERALL_AVAILABILITY_CATEGORY);
    }
%>

<%
    String nodeIdString = request.getParameter("node");

    if (nodeIdString == null) {
        throw new MissingParameterException("node");
    }

    int nodeId = WebSecurityUtils.safeParseInt(nodeIdString);

    //get the node's overall service level availiability for the last 24 hrs
    double overallRtcValue = m_model.getNodeAvailability(nodeId);

    String availClass;
    String availValue;

    long timelineEnd = new Date().getTime() / 1000;
    long timelineStart = timelineEnd - 3600 * 24;
    int timelineWidth = 300;
%>

<div id="availability-box">
    <h3 class="o-box">Timeline</h3>
    <table class="o-box">
        <%
            if (overallRtcValue < 0) {
                availClass = "Indeterminate";
                availValue = "Unmanaged";
            } else {
                availClass = CategoryUtil.getCategoryClass(m_normalThreshold, m_warningThreshold, overallRtcValue);
                availValue = CategoryUtil.formatValue(overallRtcValue) + "%";
            }

            if (overallRtcValue >= 0) {
                Interface[] availIntfs = NetworkElementFactory.getInstance(getServletContext()).getActiveInterfacesOnNode(nodeId);

                if (availIntfs.length == 0) {
        %>
        <tr class="CellStatus">
            <td colspan="3" class="<%= availClass %> nobright">No timeline data available</td>
        </tr>
        <%
            }

            for (int i = 0; i < availIntfs.length; i++) {
                Interface intf = availIntfs[i];
                String ipAddr = intf.getIpAddress();
        %>
        <c:url var="interfaceLink" value="element/interface.jsp">
            <c:param name="node" value="<%=String.valueOf(nodeId)%>"/>
            <c:param name="intf" value="<%=ipAddr%>"/>
        </c:url>
        <%
            if (intf.isManaged()) {
                double intfValue = m_model.getInterfaceAvailability(nodeId, ipAddr);
                Service[] svcs = ElementUtil.getServicesOnInterface(nodeId, ipAddr, getServletContext());

                if (svcs.length > 0) {
        %>

        <tr class="CellStatus">
            <%
                if (svcs.length < 1) {
                    availClass = "Indeterminate";
                    availValue = "Not Monitored";
                } else if (!ElementUtil.hasLocallyMonitoredServices(svcs)) {
                    availClass = "Indeterminate";
                    availValue = "Remotely Monitored";
                } else {
                    availClass = CategoryUtil.getCategoryClass(m_normalThreshold, m_warningThreshold, intfValue);
                    availValue = CategoryUtil.formatValue(intfValue) + "%";
                }

                int c = 1;

                for (int j = 0; j < svcs.length; j++) {
                    if (svcs[j].isManaged()) {
                        c++;
                    }
                }
            %>
            <td class="<%= availClass %> nobright" rowspan="<%=c%>"><a
                    href="<c:out value="${interfaceLink}"/>"><%=ipAddr%>
            </a></td>
            <td class="<%= availClass %> nobright">Time</td>
            <td class="<%= availClass %> bright"><img
                    src="/opennms/rest/timeline/header/<%=timelineStart%>/<%=timelineEnd%>/<%=timelineWidth%>"></td>
        </tr>

        <%
            for (int j = 0; j < svcs.length; j++) {

                Service service = svcs[j];

                if (service.isManaged()) {
                    double svcValue = m_model.getServiceAvailability(nodeId, ipAddr, service.getServiceId());
                    availClass = CategoryUtil.getCategoryClass(m_normalThreshold, m_warningThreshold, svcValue);
                    availValue = CategoryUtil.formatValue(svcValue) + "%";
                } else {
                    availClass = "Indeterminate";
                    availValue = ElementUtil.getServiceStatusString(service);
                }

                String timelineUrl = "/opennms/rest/timeline/html/" + String.valueOf(nodeId) + "/" + ipAddr + "/" + service.getServiceName() + "/" + timelineStart + "/" + timelineEnd + "/" + timelineWidth;

                if (service.isManaged()) {
        %>

        <c:url var="serviceLink" value="element/service.jsp">
            <c:param name="node" value="<%=String.valueOf(nodeId)%>"/>
            <c:param name="intf" value="<%=ipAddr%>"/>
            <c:param name="service" value="<%=String.valueOf(service.getServiceId())%>"/>
        </c:url>
        <tr class="CellStatus">
            <td class="<%= availClass %> nobright"><a
                    href="<c:out value="${serviceLink}"/>"><%=service.getServiceName()%>
            </a></td>
            <td class="<%= availClass %> bright">
                <script src="<%=timelineUrl%>"></script>
            </td>
        </tr>
        <% }
        }
        }
        } else {
            if ("0.0.0.0".equals(ipAddr)) {
            } else {
        %>
        <tr class="CellStatus">
            <td><a href="<c:out value="${interfaceLink}"/>"><%=ipAddr%>
            </a></td>
            <td class="Indeterminate" colspan="2"><%=ElementUtil.getInterfaceStatusString(intf)%>
            </td>
        </tr>
        <%
                        }
                    }
                }
            }
        %>
    </table>

</div>
