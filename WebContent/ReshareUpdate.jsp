<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Update an reshare</title>
</head>
<body>
<h1>Update Reshare</h1>
<form action="reshareupdate" method="post">
	<p>
		<label for="agentname">AgentName</label>
		<input id="agentname" name="agentname" value="${fn:escapeXml(param.agentname)}">
	</p>

	<p>
		<label for="employername">EmployerName</label>
		<input id="employername" name="employername" value="">
	</p>

	<p>
		<label for="newagentname">new Agent Name</label>
		<input id="newagentname" name="newagentname" value="">
	</p>


	<p>
		<input type="submit">
	</p>
</form>
<br/><br/>
<p>
	<span id="successMessage"><b>${messages.success}</b></span>
</p>
</body>
</html>