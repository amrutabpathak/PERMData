<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!doctype html>
<html lang="en">
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


<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<!-- <title>Create a Job</title> -->
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
	<h1 class="h3 mb-3 font-weight-normal">Create Job</h1>
	<form action="jobcreate" method="post" class="form-signin">
		<p>
			<label for="jobid" class="sr-only">Job Id</label>
			<input type="number" step="1" id="jobid" name="jobid" class="form-control" placeholder="Job Id" value="" required autofocus>
		</p>
		<p>
			<label for="city" class="sr-only">City</label>
			<input id="city" name="city" class="form-control" placeholder="City" value="" required autofocus>
		</p>
		<p>
			<label for="state" class="sr-only">State</label>
			<input id="state" name="state" class="form-control" placeholder="State" value="" required autofocus>
		</p>
		<p>
			<label for="code" class="sr-only">Code</label>
			<input type="number" step="1" id="code" name="code" class="form-control" placeholder="Code" value="" required autofocus>
		</p>
		<p>
			<label for="jobtitle" class="sr-only">Job Title</label>
			<input id="jobtitle" name="jobtitle" class="form-control" placeholder="Job Title" value="" required autofocus>
		</p>
		<p>
			<label for="education" class="sr-only">Education</label>
			<input id="education" name="education" list="eduation" class="form-control" placeholder="Education" value="" required autofocus>
			<datalist id="education">
			    <option value="Bachelor's">
			    <option value="Master's">
			    <option value="High School">
			    <option value="Associate's">
			    <option value="Doctorate">
			    <option value="None">
			    <option value="Other">
			  </datalist>
		
		</p>
		<p>
			<label for="educationother" class="sr-only">Education Other</label>
			<input id="educationother" name="educationother" class="form-control" placeholder="Education Other" value="" required autofocus>
		</p>
		<p>
			<label for="major" class="sr-only">Major</label>
			<input id="major" name="major" class="form-control" placeholder="Major" value="" required autofocus>
		</p>
		<p>
			<label for="requirestraining" class="sr-only">Req Training</label>
			<input id="requirestraining" list="binary" name="requirestraining" class="form-control" placeholder="Req Training" value="" required autofocus>
			<datalist id="binary">
			    <option value="Y">
			    <option value="N">
			  </datalist>
		</p>
		<p>
			<label for="trainingmonths" class="sr-only">Training Months</label>
			<input type="number" type="number" min="0" max="50" step="1" id="trainingmonths" name="trainingmonths" class="form-control" placeholder="Training Months" value="" required autofocus>
		</p>
		<p>
			<label for="trainingfield" class="sr-only">Training Field</label>
			<input id="trainingfield" name="trainingfield" class="form-control" placeholder="Training Field" value="" required autofocus>
		</p>
		<p>
			<label for="requiresexp" class="sr-only">Requires Exp</label>
			<input id="requiresexp" list="binary" name="requiresexp" class="form-control" placeholder="Requires Exp" value="" required autofocus>
		</p>
		<p>
			<label for="expmonths" class="sr-only">ExpMonths</label>
			<input type="number" type="number" step="1" id="expmonths" name="expmonths" class="form-control" placeholder="ExpMonths" value="" required autofocus>
		</p>
		<p>
			<label for="requiresaltfield" class="sr-only">RequiresAltField</label>
			<input id="requiresaltfield" list="binary" name="requiresaltfield" class="form-control" placeholder="RequiresAltField" value="" required autofocus>
		</p>
		<p>
			<label for="altfieldname" class="sr-only">AltFieldName</label>
			<input id="altfieldname" name="altfieldname" class="form-control" placeholder="AltFieldName" value="" required autofocus>
		</p>
		<p>
			<label for="comboeduexpdegree" class="sr-only">ComboEduExpDegree</label>
			<input id="comboeduexpdegree" name="comboeduexpdegree" class="form-control" placeholder="ComboEduExpDegree" value="" required autofocus>
		</p>
		<p>
			<label for="comboeduexpdegreeother" class="sr-only">ComboEduExpDegreeOther</label>
			<input id="comboeduexpdegreeother" name="comboeduexpdegreeother" class="form-control" placeholder="ComboEduExpDegreeOther" value="" required autofocus>
		</p>
		<p>
			<label for="comboeduexpyrs" class="sr-only">ComboEduExpYrs</label>
			<input type="number" step="1" min="0" max="50" id="comboeduexpyrs" name="comboeduexpyrs" class="form-control" placeholder="ComboEduExpYrs" value="" required autofocus>
		</p>
		<p>
			<label for="wageofferfrom9089" class="sr-only">WageOfferFrom9089</label>
			<input  type="number" id="wageofferfrom9089" name="wageofferfrom9089" class="form-control" placeholder="WageOfferFrom9089" value="" required autofocus>
		</p>
		<p>
			<label for="wageofferto9089" class="sr-only">WageOfferTo9089</label>
			<input  type="number" id="wageofferto9089" name="wageofferto9089" class="form-control" placeholder="WageOfferTo9089" value="" required autofocus>
		</p>
		<p>
			<label for="wageofferunit" class="sr-only">WageOfferUnit</label>
			<input id="wageofferunit" name="wageofferunit" class="form-control" placeholder="WageOfferUnit" value="" required autofocus>
		</p>
		<p>
			<label for="level9089" class="sr-only">Level9089</label>
			<input id="level9089" list="level" name="level9089" class="form-control" placeholder="Level9089" value="" required autofocus>
			<datalist id="level">
				<option value="Level I">
				<option value="Level II">
				<option value="Level III">
				<option value="Level IV">
				<option value="N/A">				
			</datalist>
			
		</p>
		<p>
			<label for="amount" class="sr-only">Amount</label>
			<input  type="number" id="amount" name="amount" class="form-control" placeholder="Amount" value="" required autofocus>
		</p>
		<p>
			<label for="unitofpay" class="sr-only">UnitOfPay</label>
			<input id="unitofpay" list="units" name="unitofpay" class="form-control" placeholder="UnitOfPay" value="" required autofocus>
			<datalist id="unitofpay">
				<option value="Year">
				<option value="Hour">
				<option value="Bi-weekly">
				<option value="Week">
				<option value="Month">
			</datalist>
		</p>
		<p>
			<label for="sourcename" class="sr-only">SourceName</label>
			<input id="sourcename" name="sourcename" class="form-control" placeholder="SourceName" value="" required autofocus>
		</p>
		<p>
			<label for="sourcenameother" class="sr-only">SourceNameOther</label>
			<input id="sourcenameother" name="sourcenameother" class="form-control" placeholder="SourceNameOther" value="" required autofocus>
		</p>
		<p>
			<label for="determdate" class="sr-only">DetermDate</label>
			<input  type="date" id="determdate" name="determdate" class="form-control" placeholder="DetermDate" value="" required autofocus>
		</p>
		<p>
			<label for="expirationdate" class="sr-only">ExpirationDate</label>
			<input  type="date" id="expirationdate" name="expirationdate" class="form-control" placeholder="ExpirationDate" value="" required autofocus>
		</p>
		<p>
			<label for="naicscode" class="sr-only">NAICS</label>
			<input  type="number" id="naicscode" name="naicscode" class="form-control" placeholder="NAICS" value="" required autofocus>
		</p>
		<p>
			<label for="socsystem" class="sr-only">Soc System</label>
			<input id="socsystem" name="socsystem" class="form-control" placeholder="Soc System" value="" required autofocus>
		</p>
	
		<p>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Create</button>
		</p>
	</form>
	<br/><br/>
	<p>
		<span id="successMessage"><b>${messages.success}</b></span>
	</p>
	
	
	<p class="mt-5 mb-3 text-muted">&copy; 2019-2020</p>



	<footer class="mastfoot mt-auto">

	</footer>
</div>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="RES/popper.min.js"></script>
<script src="RES/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
</body>
</html>