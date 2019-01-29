<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Filter based reports</title>
<link rel="stylesheet" type="text/css" href="FilterBasedReports.css">
</head>
<body>
<script type="text/javascript" src="FilterBasedReport.js"></script>
<h1 align=center>Reports Based On Filters</h1>
<form>
<table ><tr><td><br><BR>
	<select name="filter"  id=filter onchange="getData();">
	<option selected>Select filter</option>
	<option value="subject">Subject</option>
	<option value="available">Available</option>
	</select>
	</td></tr><tr><td><br><br>
	<div id="subject" hidden=true>
		<select id=subject_filter onchange="getSubjectData();">
		<option>Select subject</option>
		<option value="Novel">Novel</option>
		<option value="Educational">Educational</option>
		</select>
		
	</div>
	</td></tr><tr><td colspan=2><br><br>
	<div id=availableDiv hidden=true style="width:1000px;left:-10px;table-width=100%;" ></div></td></tr>
	<tr><td colspan=2><div id=subjectDiv hidden=true style="width:1000px;left:10px"></div></td></tr>
	</table>
</form>
</body>
</html>