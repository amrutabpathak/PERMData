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


	<form action="applicantdelete" method="post" class="form-signin">
		<%--<img class="mb-4" src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">--%>
		<h1 class="h3 mb-3 font-weight-normal">Delete An Applicant</h1>

			<p>
			<div <c:if test="${messages.disableSubmit}">style="display:none"</c:if>>

			<label for="ApplicantID" class="sr-only">ApplicantID</label>
			<input type="ApplicantID" id="ApplicantID" name="ApplicantID" class="form-control" placeholder="ApplicantID"  value="${fn:escapeXml(param.agentname)}"required autofocus>

			</div>
			</p>
			<p>
			<span id="submitButton" <c:if test="${messages.disableSubmit}">style="display:none"</c:if>>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Delete</button>
			</span>
			</p>

	</form>
	<p></p>
	<p></p>
	<p></p>
	<p></p>


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

