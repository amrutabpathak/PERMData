<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find an Employer</title>
</head>
<body>
	<form action="findemployer" method="get">
		<h1>Search for a Employer by Name</h1>
		<p>
			<label for="employername">EmployerName</label>
			<input id="employername" name="employername" value="${fn:escapeXml(param.employername)}">
		</p>
		<p>
			<input type="submit">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>

	<h1>Matching Employer</h1>
        <table border="1">
            <tr>
                <th>Name</th>
                <th>Address1</th>
                <th>Address2</th>
                <th>City</th>
                <th>State</th>
                <th>Country</th>
                <th>PostalCoder</th>
                <th>Phone</th>
                <th>PhoneExt</th>
                <th>NumOfEmployee</th>
                <th>EstablishedYear</th>
                <th>FwOwnership</th>
            </tr>
            <c:forEach items="${employers}" var="employer" >
                <tr>
                    <td><c:out value="${employer.getName()}" /></td>
                    <td><c:out value="${employer.getAddress1()}" /></td>
                    <td><c:out value="${employer.getAddress2()}" /></td>
                    <td><c:out value="${employer.getCity()}" /></td>
                    <td><c:out value="${employer.getState()}" /></td>
                    <td><c:out value="${employer.getCountry()}" /></td>
                    <td><c:out value="${employer.getPostalCode()}" /></td>
                    <td><c:out value="${employer.getPhone()}" /></td>
                    <td><c:out value="${employer.getPhoneExt()}" /></td>
                    <td><c:out value="${employer.getNumOfEmployee()}" /></td>
                    <td><c:out value="${employer.getEstablishedYear()}" /></td>
                    <td><c:out value="${employer.isFwOwnershipInterest()}" /></td>
                </tr>
            </c:forEach>
       </table>
</body>
</html>
