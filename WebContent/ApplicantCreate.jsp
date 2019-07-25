<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create an Applicant</title>
</head>
<body>
	<h1>Create Applicant</h1>
	<form action="applicantcreate" method="post">
		
		<p>
			<label for="City">City</label>
			<input id="City" name="City" value="">
		</p>
		<p>
			<label for="State">State</label>
			<input id="State" name="State" value="">
		</p>
		<p>
			<label for="Code">Code</label>
			<input id="Code" name="Code" value="">
		</p>
		<p>
			<label for="Citizenship">Citizenship</label>
			<input id="Citizenship" name="Citizenship" value="">
		</p>
		<p>
			<label for="BirthCountry">BirthCountry</label>
			<input id="BirthCountry" name="BirthCountry" value="">
		</p>
		<p>
			<label for="AdmissionClass">AdmissionClass</label>
			<input id="AdmissionClass" name="AdmissionClass" value="">
		</p>
		<p>
			<label for="Education">Education</label>
			<input id="Education" name="Education" value="">
		</p>
		<p>
			<label for="EducationOther">EducationOther</label>
			<input id="EducationOther" name="EducationOther" value="">
		</p>
		<p>
			<label for="Major">Major</label>
			<input id="Major" name="Major" value="">
		</p>
		<p>
			<label for="YearCompleted">YearCompleted</label>
			<input id="YearCompleted" name="YearCompleted" value="">
		</p>
		<p>
			<label for="Institution">Institution</label>
			<input id="Institution" name="Institution" value="">
		</p>
		
		<p>
			<label for="JobID">JobID</label>
			<input id="JobID" name="JobID" value="">
		</p>
		
		<p>
			<label for="EmployerName">EmployerName</label>
			<input id=""EmployerName"" name="EmployerName" value="">
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