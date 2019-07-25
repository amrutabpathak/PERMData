<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find an reshare</title>
</head>
<body>
	<form action="findreshare" method="get">
		<h1>Search for a reshare by Name</h1>
		<p>
			<label for="agentname">AgentName</label>
			<input id="agentname" name="agentname" value="${fn:escapeXml(param.agentname)}">
		</p>
        <p>
            <label for="employername">EmployerName</label>
            <input id="employername" name="employername" value="${fn:escapeXml(param.employername)}">
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
                <th>Id</th>
                <th>Agent</th>
                <th>Employer</th>
            </tr>
            <c:forEach items="${reshares}" var="reshare" >
                <tr>
                    <th><c:out value="${reshare.getId()}" /></th>
                    <th><c:out value="${reshare.getAgentName()}" /></th>
                    <th><c:out value="${reshare.getEmployerName()}" /></th>
                </tr>
            </c:forEach>
       </table>
</body>
</html>
