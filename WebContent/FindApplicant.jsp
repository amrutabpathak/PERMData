<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find Applicants</title>
</head>
<body>
	<form action="findapplicant" method="get">
		<h1>Search for applicants by birth country</h1>
		<p>
			<label for="BirthCountry">BirthCountry</label>
			<input id="BirthCountry" name="BirthCountry" value="${fn:escapeXml(param.BirthCountry)}">
		</p>
		<p>
			<input type="submit">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>

	<h1>Matching Applicants</h1>
        <table border="1">
            <tr>
                <th>ApplicantId</th>
                <th>City</th>
                <th>State</th>
                <th>Code</th>
                <th>Citizenship</th>
                <th>BirthCountry</th>
                <th>AdmissionClass</th>
                <th>Education</th>
                <th>EducationOther</th>
                <th>Major</th>
                <th>YearCompleted</th>
                <th>Institution</th>
                <th>JobID</th>
                <th>EmployerName</th>
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
                    <td><c:out value="${applicant.getEducation()}" /></td>
                    <td><c:out value="${applicant.getEducationOther()}" /></td>
                    <td><c:out value="${applicant.getMajor()}" /></td>
                    <td><c:out value="${applicant.getYearCompleted()}" /></td>
                    <td><c:out value="${applicant.getInstitution()}" /></td>
                    <td><c:out value="${applicant.getJob().getJobId()}" /></td>
                    <td><c:out value="${applicant.getEmployer().getName()}" /></td>
                    
                </tr>
            </c:forEach>
       </table>
</body>
</html>