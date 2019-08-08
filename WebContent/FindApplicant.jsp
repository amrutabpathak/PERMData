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


    <form action="findapplicant" method="get" class="form-signin">
        <%--<img class="mb-4" src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">--%>
        <h1 class="h3 mb-3 font-weight-normal">Find An Applicant</h1>
        <label for="BirthCountry" class="sr-only">BirthCountry</label>
            <%--<input id="agentname" name="agentname" value="${fn:escapeXml(param.agentname)}">--%>
        <input type="BirthCountry" id="BirthCountry" name="BirthCountry" class="form-control" placeholder="BirthCountry" value="${fn:escapeXml(param.agentname)}"required autofocus>


            <p></p>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Find</button>

    </form>
    <p></p>
    <p></p>
    <p></p>
    <p></p>



	<h1 class="h3 mb-3 font-weight-normal">Matching Applicants</h1>
        <table border="1">
            <tr>
                <th>ApplicantId</th>
                <th>City</th>
                <th>State</th>
                <th>Code</th>
                <th>Citizenship</th>
                <th>BirthCountry</th>
                <th>AdmissionClass</th>
                
            </tr>
            <c:forEach items="${applicants}" var="applicant" >
                <tr>
                    <td><c:out value="${applicant.getApplicantId()}" /></td>
                    <td><c:out value="${applicant.getCity()}" /></td>
                    <td><c:out value="${applicant.getState()}" /></td>
                    <td><c:out value="${applicant.getCode()}" /></td>
                    <td><c:out value="${applicant.getCitizenship()}" /></td>
                    <td><c:out value="${applicant.getBirthCountry()}" /></td>
                    <td><c:out value="${applicant.getAdmissionClass()}" /></td>
                   
                    
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
