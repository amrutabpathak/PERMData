<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find a Naics</title>
</head>
<body>
	<form action="findnaics" method="post">
		<h1>Search for a Naics by Naics Code</h1>
		<p>
			<label for="naicscode">SOC Title</label>
			<input id="naicscode" name="naicscode" value="${fn:escapeXml(param.naicscode)}">
		</p>
		<p>
			<input type="submit">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>
	
	<h1>Matching Naics Details</h1>
        <table border="1">
            <tr>
                <th>NaicsCode</th>
                <th>NaicsTitle</th>
            </tr>
            <c:forEach items="${naics}" var="naic" >
                <tr>
                    <td><c:out value="${naic.getNaicsCode()}" /></td>
                    <td><c:out value="${naic.getNaicsTitle()}" /></td>                    
                </tr>
            </c:forEach>
       </table>
</body>
</html>
