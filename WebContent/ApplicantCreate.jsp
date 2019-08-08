<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.ico">

	<title>Cover Template for Bootstrap</title>

	<link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/cover/">

	<!-- Bootstrap core CSS -->
	<link href="RES/bootstrap-4.0.0-dist/css/bootstrap.min.css" rel="stylesheet">

	<link href="RES/signin.css" rel="stylesheet">
	<!-- Custom styles for this template -->
	<link href="RES/cover.css" rel="stylesheet">

<title>Create an Applicant</title>
</head>

<body class="text-center">

<div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
	<header class="masthead mb-auto">
		<div class="inner">
			<h3 class="masthead-brand">PERM</h3>
			<nav class="nav nav-masthead justify-content-center">
				<a class="nav-link active" href="#">Home</a>
				<a class="nav-link" href="#">Advertisements</a>
				<a class="nav-link" href="#">Applicant</a>
				<a class="nav-link" href="#">Employer</a>
				<a class="nav-link" href="#">Job</a>
				<a class="nav-link" href="#">Naics</a>
				<a class="nav-link" href="#">SOCSystem</a>
			</nav>
		</div>
	</header>
	
		<form form action="applicantcreate" method="post" class="form-signin">
		<%--<img class="mb-4" src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">--%>
		<h1 class="h3 mb-3 font-weight-normal">Create An Applicant</h1>

		<p>
			<label for="ApplicantID" class="sr-only">ApplicantID</label>
			<input id="ApplicantID" name="ApplicantID" placeholder="ApplicantID" value=""required autofocus>
		</p>
		<p>
			<label for="City" class="sr-only">City</label>
			<input id="City" name="City" placeholder="City" value=""required autofocus>
		</p>
		<p>
			<label for="State" class="sr-only">State</label>
			<input id="State" name="State" placeholder="State" value=""required autofocus>
		</p>
		<p>
			<label for="Code" class="sr-only">Code</label>
			<input id="Code" name="Code" placeholder="Code" value=""required autofocus>
		</p>
		<p>
			<label for="Citizenship" class="sr-only">Citizenship</label>
			<input id="Citizenship" name="Citizenship" placeholder="Citizenship" value=""required autofocus>
		</p>
		<p>
			<label for="BirthCountry" class="sr-only">BirthCountry</label>
			<input id="BirthCountry" name="BirthCountry" placeholder="BirthCountry" value=""required autofocus>
		</p>
		<p>
			<label for="AdmissionClass" class="sr-only">AdmissionClass</label>
			<input id="AdmissionClass" name="AdmissionClass" placeholder="AdmissionClass" value=""required autofocus>
		</p>
		<p>
			<label for="Education" class="sr-only">Education</label>
			<input id="Education" name="Education" placeholder="Education" value=""required autofocus>
		</p>
		<p>
			<label for="EducationOther" class="sr-only">EducationOther</label>
			<input id="EducationOther" name="EducationOther" placeholder="EducationOther" value=""required autofocus>
		</p>
		<p>
			<label for="Major" class="sr-only">Major</label>
			<input id="Major" name="Major" placeholder="Major" value=""required autofocus>
		</p>
		<p>
			<label for="YearCompleted" class="sr-only">YearCompleted</label>
			<input id="YearCompleted" name="YearCompleted" placeholder="YearCompleted" value=""required autofocus>
		</p>
		<p>
			<label for="Institution" class="sr-only">Institution</label>
			<input id="Institution" name="Institution" placeholder="Institution" value=""required autofocus>
		</p>
		
		<p>
			<label for="JobID" class="sr-only">JobID</label>
			<input id="JobID" name="JobID" placeholder="ApplicantID" value=""required autofocus>
		</p>
		
		<p>
			<label for="EmployerName" class="sr-only">EmployerName</label>
			<input id="EmployerName" name="EmployerName" placeholder="EmployerName" value=""required autofocus>
		</p>
		
	
		<p></p>

		<button class="btn btn-lg btn-primary btn-block" type="submit">Create</button>
		<p>
		<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>
	