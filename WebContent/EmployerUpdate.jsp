<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update an Employer</title>
</head>
<body>
	<h1>Update BlogUser</h1>
	<form action="employerupdate" method="post">
		<p>
			<label for="employername">EmployerName</label>
			<input id="employername" name="employername" value="${fn:escapeXml(param.employername)}">
		</p>


		<p>
			<label for="newemployername">New EmployerName</label>
			<input id="newemployername" name="newemployername" value="">
		</p>
		<p>
			<label for="Address1">New Address1</label>
			<input id="Address1" name="Address1" value="">
		</p>
		<p>
			<label for="Address2">New Address2</label>
			<input id="Address2" name="Address2" value="">
		</p>
		<p>
			<label for="City">New City</label>
			<input id="City" name="City" value="">
		</p>
		<p>
			<label for="State">New State</label>
			<input id="State" name="State" value="">
		</p>
		<p>
			<label for="Country">New Country</label>
			<input id="Country" name="Country" value="">
		</p>
		<p>
			<label for="PostalCode">New PostalCode</label>
			<input id="PostalCode" name="PostalCode" value="">
		</p>
		<p>
			<label for="Phone">New Phone</label>
			<input id="Phone" name="Phone" value="">
		</p>
		<p>
			<label for="PhoneExt">New PhoneExt</label>
			<input id="PhoneExt" name="PhoneExt" value="">
		</p>
		<p>
			<label for="NumOfEmployee">New NumOfEmployee</label>
			<input id="NumOfEmployee" name="NumOfEmployee" value="">
		</p>
		<p>
			<label for="EstablishedYear">New EstablishedYear</label>
			<input id="EstablishedYear" name="EstablishedYear" value="">
		</p>
		<p>
			<label for="FwOwnership">New FwOwnership</label>
			<input id="FwOwnership" name="FwOwnership" value="">
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