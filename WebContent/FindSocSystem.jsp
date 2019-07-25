<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find a User</title>
</head>
<body>
	<form action="findsocsystem" method="post">
		<h1>Search for a SOC System by SOC System Title</h1>
		<p>
			<label for="soctitle">SOC Title</label>
			<input id="soctitle" name="soctitle" value="${fn:escapeXml(param.prevailingwagesoctitle)}">
		</p>
		<p>
			<input type="submit">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>
	<br/>
	<div id="socSystemCreate"><a href="socsystemcreate">Create SOC System</a></div>
	<br/>
	<h1>Matching SOC Details</h1>
        <table border="1">
            <tr>
                <th>PrevailingWageSocCode</th>
                <th>PrevailingWageSocTitle</th>
                <th>Delete SocSystem</th>
                <th>Update SocSystem</th>
            </tr>
            <c:forEach items="${socSystems}" var="socSystem" >
                <tr>
                    <td><c:out value="${socSystem.getPrevailingWageSocCode()}" /></td>
                    <td><c:out value="${socSystem.getPrevailingWageSocTitle()}" /></td>
                    <td><a href="socsystemdelete?prevailingwagesoccode=<c:out value="${socSystem.getPrevailingWageSocCode()}"/>">Delete</a></td>
                    <td><a href="socsystemupdate?prevailingwagesoccode=<c:out value="${socSystem.getPrevailingWageSocCode()}"/>">Update</a></td>
                </tr>
            </c:forEach>
       </table>
</body>
</html>
