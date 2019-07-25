<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find an Advertisement</title>
</head>
<body>
	<form action="findadvertisement" method="get">
		<h1>Search for an advertisement by ID</h1>
		<p>
			<label for="AdvertisementId">AdvertisementId</label>
			<input id="AdvertisementId" name="AdvertisementId" value="${fn:escapeXml(param.AdvertisementId)}">
		</p>
		<p>
			<input type="submit">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>

	<h1>Matching Advertisement</h1>
        <table border="1">
            <tr>
                <th>AdvertisementId</th>
                <th>Means</th>
                <th>StartDate</th>
                <th>EndDate</th>
                <th>JobId</th>
               
            </tr>
            <c:forEach items="${advertisements}" var="advertisement" >
                <tr>
                    <td><c:out value="${advertisement.getAdvertisementId()}" /></td>
                    <td><c:out value="${advertisement.getMeans()}" /></td>
                    <td><c:out value="${advertisement.getStartDate()}" /></td>
                    <td><c:out value="${advertisement.getEndDate()}" /></td>
                    <td><c:out value="${advertisement.getJob().getJobId()}" /></td>
                    
                </tr>
            </c:forEach>
       </table>
</body>
</html>