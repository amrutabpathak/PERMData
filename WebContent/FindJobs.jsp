<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find a Job</title>
</head>
<body>
	<form action="findjobs" method="post">
		<h1>Search for a Job by SOC Code</h1>
		<p>
			<label for="soccode">Soc Code</label>
			<input id="soccode" name="soccode" value="${fn:escapeXml(param.soccode)}">
		</p>
		<p>
			<input type="submit">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>
	<br/>
	<div id="jobCreate"><a href="jobcreate">Create a Job</a></div>
	<br/>
	<h1>Matching Jobs</h1>
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
                 <th>Delete </th>
                 <th>Update </th>
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
                   
                    <td><a href="jobdelete?jobid=<c:out value="${job.getJobId()}"/>">Delete</a></td>
                    <td><a href="jobupdate?jobid=<c:out value="${job.getJobId()}"/>">Update</a></td>
                </tr>
            </c:forEach>
       </table>
</body>
</html>
