<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ include file="Header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Member</title>
<script type="text/javascript">
	function confirmDelete(){
		var message=confirm("Are you sure");
		
	}
</script>
</head>
<link rel="stylesheet" type="text/css" href="DeleteMember.css">

<body>
<h1 align=center>Delete Member</h1>
 		<form action="DeleteMember" method="post">
 		<table >
 			<tr><td><br><br><input type=text name="delete_member" required=required placeholder=username><br></td></tr>
 			<tr><td><br><input type=submit name=delete_member value= "Delete member" onclick="confirmDelete()" >
 			</table>
 			
 		</form>
 		
 		
</body>
</html>