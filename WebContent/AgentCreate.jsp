<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create an Agent</title>
</head>
<body>
	<h1>Create Agent</h1>
	<form action="agentcreate" method="post">
		<p>
			<label for="agentname">AgentName</label>
			<input id="agentname" name="agentname" value="">
		</p>
		<p>
			<label for="City">City</label>
			<input id="City" name="City" value="">
		</p>
		<p>
			<label for="State">State</label>
			<input id="State" name="State" value="">
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