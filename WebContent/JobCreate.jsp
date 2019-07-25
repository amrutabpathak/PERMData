<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a Job</title>
</head>
<body>
	<h1>Create Job</h1>
	<form action="jobcreate" method="post">
		<p>
			<label for="city">City</label>
			<input id="city" name="city" value="">
		</p>
		<p>
			<label for="state">State</label>
			<input id="state" name="state" value="">
		</p>
		<p>
			<label for="code">Code</label>
			<input id="code" name="code" value="">
		</p>
		<p>
			<label for="jobtitle">Job Title</label>
			<input id="jobtitle" name="jobtitle" value="">
		</p>
		<p>
			<label for="education">Education</label>
			<input id="education" name="education" value="">
		</p>
		<p>
			<label for="educationother">Education Other</label>
			<input id="educationother" name="educationother" value="">
		</p>
		<p>
			<label for="major">Major</label>
			<input id="major" name="major" value="">
		</p>
		<p>
			<label for="requirestraining">Req Training</label>
			<input id="requirestraining" name="requirestraining" value="">
		</p>
		<p>
			<label for="trainingMonths">Training Months</label>
			<input id="trainingMonths" name="trainingMonths" value="">
		</p>
		<p>
			<label for="trainingField">Training Field</label>
			<input id="trainingField" name="trainingField" value="">
		</p>
		<p>
			<label for="requiresexp">Requires Exp</label>
			<input id="requiresexp" name="requiresexp" value="">
		</p>
		<p>
			<label for="expmonths">ExpMonths</label>
			<input id="expmonths" name="expmonths" value="">
		</p>
		<p>
			<label for="requiresaltfield">RequiresAltField</label>
			<input id="requiresaltfield" name="requiresaltfield" value="">
		</p>
		<p>
			<label for="altfieldname">AltFieldName</label>
			<input id="altfieldname" name="altfieldname" value="">
		</p>
		<p>
			<label for="comboeduexpdegree">ComboEduExpDegree</label>
			<input id="comboeduexpdegree" name="comboeduexpdegree" value="">
		</p>
		<p>
			<label for="comboeduexpdegreeother">comboEduExpDegreeOther</label>
			<input id="comboeduexpdegreeother" name="comboeduexpdegreeother" value="">
		</p>
		<p>
			<label for="comboeduexpyrs">ComboEduExpYrs</label>
			<input id="comboeduexpyrs" name="comboeduexpyrs" value="">
		</p>
		<p>
			<label for="wageofferfrom9089">wageOfferFrom9089</label>
			<input id="wageofferfrom9089" name="wageofferfrom9089" value="">
		</p>
		<p>
			<label for="wageofferto9089">WageOfferTo9089</label>
			<input id="wageofferto9089" name="wageofferto9089" value="">
		</p>
		<p>
			<label for="wageofferunit">WageOfferUnit</label>
			<input id="wageofferunit" name="wageofferunit" value="">
		</p>
		<p>
			<label for="level9089">Level9089</label>
			<input id="level9089" name="level9089" value="">
		</p>
		<p>
			<label for="amount">Amount</label>
			<input id="amount" name="amount" value="">
		</p>
		<p>
			<label for="unitofpay">UnitOfPay</label>
			<input id="unitofpay" name="unitofpay" value="">
		</p>
		<p>
			<label for="sourcename">SourceName</label>
			<input id="sourcename" name="sourcename" value="">
		</p>
		<p>
			<label for="sourcenameother">SourceNameOther</label>
			<input id="sourcenameother" name="sourcenameother" value="">
		</p>
		<p>
			<label for="determdate">DetermDate</label>
			<input id="determdate" name="determdate" value="">
		</p>
		<p>
			<label for="expirationdate">ExpirationDate</label>
			<input id="expirationdate" name="expirationdate" value="">
		</p>
		<p>
			<label for="naics">NAICS</label>
			<input id="naics" name="naics" value="">
		</p>
		<p>
			<label for="socsystem">Soc System</label>
			<input id="socsystem" name="socsystem" value="">
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