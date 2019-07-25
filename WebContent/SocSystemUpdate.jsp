<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update a SOC System</title>
</head>
<body>
	<h1>Update SOC System</h1>
	<form action="socsystemupdate" method="post">
		<p>
			<label for="prevailingwagesoccode">Prevailing Wage Soc Code</label>
			<input id="prevailingwagesoccode" name="prevailingwagesoccode" value="${fn:escapeXml(param.prevailingwagesoccode)}">
		</p>
		<p>
			<label for="prevailingwagesoctitle">New Prevailing Wage Soc Title</label>
			<input id="prevailingwagesoctitle" name="prevailingwagesoctitle" value="">
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