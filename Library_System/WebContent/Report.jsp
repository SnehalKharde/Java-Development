<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reports Using Web Services</title>
<link rel="stylesheet" type="text/css" href="Report.css">
<link rel="shortcut icon" href="">
</head>
<body>

<script src="Report.js">
</script>
<form >
<h1 align=center>Reports Using Web Services</h1>
<table><tr><td colspan=2><br><br><input type=submit name=hello value="Get Report" onclick="getReports();"><br><BR></td></tr>
<tr><td>book name</td><td><input type=text id=book_name ><br><br></td></tr>
<tr><td>author name</td><td><input type=text id=author_name ><br><br></td></tr>
<tr><td>number of copies</td><td><input type=text id=number_of_copies ><br><br></td></tr>
</table>

</form>
</body>
</html>