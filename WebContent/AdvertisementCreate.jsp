<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create an Advertisement</title>
</head>
<body>
	<h1>Create Advertisement</h1>
	<form action="advertisementcreate" method="post">
		<p>
			<label for="AdvertisementId">AdvertisementId</label>
			<input id="AdvertisementId" name="AdvertisementId" value="">
		</p>
		<p>
			<label for="Means">Means</label>
			<input id="Means" name="Means" value="">
		</p>
		
		<p>
			<label for="StartDate">StartDate (yyyy-mm-dd)</label>
			<input id="StartDate" name="StartDate" value="">
		</p>
		<p>
			<label for="EndDate">EndDate (yyyy-mm-dd)</label>
			<input id="EndDate" name="EndDate" value="">
		</p>
		<p>
			<label for="JobID">JobID</label>
			<input id="JobID" name="JobID" value="">
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