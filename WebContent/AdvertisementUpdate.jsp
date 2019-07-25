<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update an Advertisement</title>
</head>
<body>
	<h1>Update Advertisement</h1>
	<form action="advertisementupdate" method="post">
		<p>
			<label for="AdvertisementId">UserName</label>
			<input id="AdvertisementId" name="AdvertisementId" value="${fn:escapeXml(param.AdvertisementId)}">
		</p>
		<p>
			<label for="Means">New Means</label>
			<input id="Means" name="Means" value="">
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