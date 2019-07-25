<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create an Application</title>
</head>
<body>
	<h1>Create Application</h1>
	<form action="applicationcreate" method="post">
		
		<p>
			<label for="casenumber">CaseNumber</label>
			<input id="casenumber" name="casenumber" value="">
		</p>
		<p>
			<label for="decistiondate">DecistionDate</label>
			<input id="decistiondate" name="decistiondate" value="">
		</p>
		<p>
			<label for="casestatus">CaseStatus</label>
			<input id="casestatus" name="casestatus" value="">
		</p>
		<p>
			<label for="casereceiveddate">CaseReceivedDate</label>
			<input id="casereceiveddate" name="casereceiveddate" value="">
		</p>
		<p>
			<label for="refile">Refile</label>
			<input id="refile" name="refile" value="">
		</p>
		<p>
			<label for="originalfiledate">OriginalFileDate</label>
			<input id="originalfiledate" name="originalfiledate" value="">
		</p>
		<p>
			<label for="scheduled">scheduled</label>
			<input id="scheduled" name="scheduled" value="">
		</p>
		<p>
			<label for="employername">EmployerName</label>
			<input id="employername" name="employername" value="">
		</p>
		<p>
			<label for="applicantid">ApplicantId</label>
			<input id="applicantid" name="applicantid" value="">
		</p>
		<p>
			<label for="agentfirmname">AgentFirmName</label>
			<input id="agentfirmname" name="agentfirmname" value="">
		</p>

		<p>
			<input type="submit">
		</p>
	</form>
	<br/><br/>
	<p>
		<span id="successMessage"><b>${messages.success}</b></span>
	</p>
</body>
</html>