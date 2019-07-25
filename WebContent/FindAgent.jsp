<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find an Agent</title>
</head>
<body>
	<form action="findagent" method="get">
		<h1>Search for a Employer by Name</h1>
		<p>
			<label for="agentname">AgentName</label>
			<input id="agentname" name="agentname" value="${fn:escapeXml(param.agentname)}">
		</p>
		<p>
			<input type="submit">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>

	<h1>Matching Agent</h1>
        <table border="1">
            <tr>
                <th>Name</th>
                <th>City</th>
                <th>State</th>
            </tr>
            <c:forEach items="${agents}" var="agent" >
                <tr>
                    <th><c:out value="${agent.getFirmName()}" /></th>
                    <th><c:out value="${agent.getCity()}" /></th>
                    <th><c:out value="${agent.getState()}" /></th>
                </tr>
            </c:forEach>
       </table>
</body>
</html>
