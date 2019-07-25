<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update a Naics</title>
</head>
<body>
	<h1>Update Naics</h1>
	<form action="naicsupdate" method="post">
		<p>
			<label for="naicscode">NaicsCode</label>
			<input id="naicscode" name="naicscode" value="${fn:escapeXml(param.naicscode)}">
		</p>

		<p>
			<label for="naicstitle">NaicsTitle</label>
			<input id="naicstitle" name="naicstitle" value="">
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