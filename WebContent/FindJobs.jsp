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
<!-- <title>Find a Job</title> -->
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

	<form action="findjobs" method="post" class="form-signin">
		<h1 class="h3 mb-3 font-weight-normal">Search for a Job by SOC Code</h1>
		<p>
			<label for="soccode" class="sr-only">Soc Code</label>
			<input id="soccode" name="soccode" class="form-control" placeholder="Soc Code"  value="${fn:escapeXml(param.soccode)}" required autofocus>
		</p>
		<p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Find</button>
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>
	<br/>
	<h1 class="h3 mb-3 font-weight-normal">Matching Jobs</h1>
        <table border="1">
            <tr>
                 <th>JobId</th> 
				 <th> City </th> 
				 <th>State </th> 
				 <th>Code </th> 
				 <th>JobTitle </th> 
				 <th>Education </th> 
				 <th>EducationOther </th> 
				 <th> Major </th> 
				 <th>RequiresTraining</th> 
				 <th> TrainingMonths </th> 
				 <th>TrainingField </th> 
				 <th>RequiresExp</th> 
				 <th>ExpMonths </th> 
				 <th>RequiresAltField </th> 
				 <th>AltFieldName </th> 
				 <th>ComboEduExpDegree </th> 
				 <th>ComboEduExpDegreeOther </th> 
				 <th>ComboEduExpYrs </th> 
				 <th>WageOfferFrom9089 </th> 
				 <th>WageOfferTo9089 </th> 
				 <th>WageOfferUnit </th> 
				 <th>Level9089 </th> 
				 <th>Amount </th> 
				 <th>UnitOfPay </th> 
				 <th>SourceName </th> 
				 <th>SourceNameOther </th> 
				 <th>DetermDate </th> 
				 <th>ExpirationDate </th> 
				 <th>PrevailingWageSocCode </th> 
				 <th>NAICSCode</th>
            </tr>
            <c:forEach items="${jobs}" var="job" >
                <tr>
                    <td><c:out value="${job.getJobId()}" /></td>
                    <td><c:out value="${job.getCity()}" /></td>
					<td><c:out value="${job.getState()}" /></td>
					<td><c:out value="${job.getCode()}" /></td>
					<td><c:out value="${job.getJobTitle()}" /></td>
					<td><c:out value="${job.getEducation().name()}" /></td>
					<td><c:out value="${job.getEducationOther()}" /></td>
					<td><c:out value="${job.getMajor()}" /></td>
					<td><c:out value="${job.getRequiresTraining().name()}" /></td>
					<td><c:out value="${job.getTrainingMonths()}" /></td>
					<td><c:out value="${job.getTrainingField()}" /></td>
					<td><c:out value="${job.getRequiresExp().name()}" /></td>
					<td><c:out value="${job.getExpMonths()}" /></td>
					<td><c:out value="${job.getRequiresAltField().name()}" /></td>
					<td><c:out value="${job.getAltFieldName()}" /></td>
					<td><c:out value="${job.getComboEduExpDegree().name()}" /></td>
					<td><c:out value="${job.getComboEduExpDegreeOther()}" /></td>
					<td><c:out value="${job.getComboEduExpYrs()}" /></td>
					<td><c:out value="${job.getWageOfferFrom9089()}" /></td>
					<td><c:out value="${job.getWageOfferTo9089()}" /></td>
					<td><c:out value="${job.getWageOfferUnit().name()}" /></td>
					<td><c:out value="${job.getLevel9089().name()}" /></td>
					<td><c:out value="${job.getAmount()}" /></td>
					<td><c:out value="${job.getUnitOfPay().name()}" /></td>
					<td><c:out value="${job.getSourceName().name()}" /></td>
					<td><c:out value="${job.getSourceNameOther()}" /></td>
					<td><fmt:formatDate value="${job.getDetermDate()}" pattern="yyyy-MM-dd"/></td>
					<td><fmt:formatDate value="${job.getExpirationDate()}" pattern="yyyy-MM-dd" /></td>
					<td><c:out value="${job.getSocSystem().getPrevailingWageSocCode()}" /></td>
					<td><c:out value="${job.getNaics().getNaicsCode()}" /></td>
                   
                </tr>
            </c:forEach>
       </table>
       
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
