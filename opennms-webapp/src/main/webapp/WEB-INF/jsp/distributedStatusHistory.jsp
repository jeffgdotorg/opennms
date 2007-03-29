<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/includes/header.jsp" flush="false">
	<jsp:param name="title" value="Distributed Status History" />
	<jsp:param name="headTitle" value="Distributed Status History" />
	<jsp:param name="breadcrumb" value="<a href='distributedStatusSummary.htm'>Distributed Status</a>" />
	<jsp:param name="breadcrumb" value="History" />
</jsp:include>

<h3>Distributed Status History for ${historyModel.chosenApplication.name} from ${historyModel.chosenMonitor.name} over ${historyModel.chosenPeriod.name}</h3>

<c:if test="${!empty historyModel.errors}">
  <ul class="error">
    <c:forEach items="${historyModel.errors}" var="error">
      <li>${error}</li>
    </c:forEach>
  </ul>
</c:if>

<form action="distributedStatusHistory.htm">
  <input type="hidden" name="previousLocation" value="${historyModel.chosenLocation.name}"/>
  
  <table class="normal">
    <tr>
      <td class="normal" align="right">Location</td>
      <td class="normal">
        <select name="location" id="location">
          <c:forEach items="${historyModel.locations}" var="location">
            <c:choose>
              <c:when test="${location.name == historyModel.chosenLocation.name}">
                <option selected="selected">${location.name}</option>
              </c:when>
              <c:otherwise>
                <option>${location.name}</option>
              </c:otherwise>
            </c:choose>
          </c:forEach>
        </select>
  	</td>
    </tr>
  
    <tr>
      <td class="normal" align="right">Location monitor</td>
      <td class="normal">
        <c:choose>
          <c:when test="${empty historyModel.monitors}">
            No location monitors have registered for this location
          </c:when>
          
  	    <c:otherwise>
            <select name="monitorId" id="monitor">
              <c:forEach items="${historyModel.monitors}" var="monitor">
                <c:choose>
                  <c:when test="${monitor.id == historyModel.chosenMonitor.id}">
                    <option value="${monitor.id}" selected="selected">${monitor.definitionName}-${monitor.id}</option>
                  </c:when>
                  <c:otherwise>
                    <option value="${monitor.id}">${monitor.name}</option>
                  </c:otherwise>
                </c:choose>
              </c:forEach>
            </select>
  	    </c:otherwise>
        </c:choose>
      </td> 
    </tr>
  
    <tr>
      <td class="normal" align="right">Application</td>
      <td class="normal">
        <select name="application" id="application">
          <c:forEach items="${historyModel.applications}" var="application">
            <c:choose>
              <c:when test="${application == historyModel.chosenApplication}">
                <option selected="selected">${application.name}</option>
              </c:when>
              <c:otherwise>
                <option>${application.name}</option>
              </c:otherwise>
            </c:choose>
          </c:forEach>
        </select>
  	</td>
    </tr>
  
    <tr>
      <td class="normal" align="right">Time Span</td>
  	<td class="normal">
  	  <select name="timeSpan" id="timeSpan">
  	    <c:forEach items="${historyModel.periods}" var="period">
            <c:choose>
              <c:when test="${period == historyModel.chosenPeriod}">
                <option value="${period.id}" selected="selected">${period.name}</option>
              </c:when>
              <c:otherwise>
  		      <option value="${period.id}">${period.name}</option>
              </c:otherwise>
            </c:choose>
  		</c:forEach>
        </select>
      </td>
    </tr>
  
    <tr>
      <td class="normal"></td>
      <td class="normal">
        <input type="submit" value="Update"/>
      </td>
    </tr>
  
    <tr>
      <td class="normal"></td>
      <td class="normal">
        <input type="button" value="View Status Details" onClick="document.viewStatusDetails.submit();"/>
      </td>
    </tr>
  </table>
</form>
  
<form action="distributedStatusDetails.htm" name="viewStatusDetails">
  <input type="hidden" name="location" value="${historyModel.chosenLocation.name}"/>
  <input type="hidden" name="application" value="${historyModel.chosenApplication.name}"/>
</form>
  
<c:forEach items="${historyModel.serviceGraphs}" var="graph">
  <p style="text-align: center">
    <c:url var="nodeUrl" value="element/node.jsp?node=${graph.service.ipInterface.node.id}"/>
    <c:url var="interfaceUrl" value="element/interface.jsp?ipinterfaceid=${graph.service.ipInterface.id}"/>
    <c:url var="serviceUrl" value="element/service.jsp?ifserviceid=${graph.service.id}"/>

    Node: <a href="${nodeUrl}">${graph.service.ipInterface.node.label}</a><br/>
    Interface: <a href="${interfaceUrl}">${graph.service.ipAddress}</a><br/>
    Service: <a href="${serviceUrl}">${graph.service.serviceName}</a><br/>

    <c:if test="${!empty graph.errors}">
      <span class="error">
        <c:forEach var="error" items="${graph.errors}">
          ${error}<br/>
        </c:forEach>
      </span>
    </c:if>
    
    <c:if test="${!empty graph.url}">
      <img src="${graph.url}"/>
    </c:if>

  </p>
</c:forEach>

<jsp:include page="/includes/footer.jsp" flush="false"/>
