<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="FilterBasedReports.css">
<meta charset="ISO-8859-1">
<title>Report</title>
</head>
<body onload="getAllReports();" >
<h1 align=center>Report</h1>
<h2 align=center>of all the books issued by the members with book and member details</h2>
<script type="text/javascript" src="ReportsForAll.js"></script>
<form method="post" action="ReportsForAll">
<table><tr><td><br>
Enter username<input  type=text id="username" name="username" onkeyup="getParticularUser();" style="align:center" >
<br><br></td></tr><tr><td></td></tr><tr><td>
<div id="detailDiv12" >

</div></td></tr>
<tr><td>
<div id="detailDiv" >

</div></td></tr>
</table></form>
</body>
</html>
