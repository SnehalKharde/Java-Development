<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Login</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="Login.css">
</head>
<body >
<h1 align=center>Login </h1>
<form action="Login" method="post"><br>
<table><tr><td>
	Enter name </td></tr><tr><td>
	<input type=text name=username placeholder=name required=required >
	<br><br></td></tr><tr><td>
	Enter password </td></tr><tr><td>
	<input type=password name=password required=required>
	<br><br></td></tr><tr><td>
	<input type=submit name=login value="Login">
	<br></td></tr>
</table>
</form>
</body>
</html>