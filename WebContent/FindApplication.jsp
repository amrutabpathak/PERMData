<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find an Application</title>
</head>
<body>
	<form action="findapplication" method="get">
		<h1>Search for an Application by CaseNumber</h1>
		<p>
			<label for="casenumber">CaseNumber</label>
			<input id="casenumber" name="casenumber" value="${fn:escapeXml(param.casenumber)}">
		</p>
		<p>
			<input type="submit">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>

	<h1>Matching Application</h1>
        <table border="1">
            <tr>
                <th>CaseNumber</th>
                <th>DecistionDate</th>
                <th>CaseStatus</th>
                <th>Refile</th>
                <th>OriginalFileDate</th>
                <th>Scheduled</th>
                <th>EmployerName</th>
                <th>ApplicantId</th>
                <th>AgentFirmName</th>
            </tr>
            <c:forEach items="${applications}" var="application" >
                <tr>
                    <td><c:out value="${application.getCaseNumber()}" /></td>
                    <td><c:out value="${application.getDecistionDate()}" /></td>
                    <td><c:out value="${application.getCaseStatus()}" /></td>
                    <td><c:out value="${application.getCaseReceivedDate()}" /></td>
                    <td><c:out value="${application.isRefile()}" /></td>
                    <td><c:out value="${application.getOriginalFileDate()}" /></td>
                    <td><c:out value="${application.isScheduled()}" /></td>
                    <td><c:out value="${application.getEmployerName()}" /></td>
                    <td><c:out value="${application.getApplicantId()}" /></td>
                    <td><c:out value="${application.getAgentFirmName()}" /></td>
                </tr>
            </c:forEach>
       </table>
</body>
</html>
