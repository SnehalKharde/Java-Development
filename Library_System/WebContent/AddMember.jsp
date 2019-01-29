<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add member</title>
<h1 align="center" >Add Member</h1>
      <link rel="stylesheet" type="text/css" href="AddMember.css">
</head>

<body >
<script type="text/javascript" src="AddMember.js">
	
	</script>
<form action="AddMember" method="post" name="register">
	<div class="registration">
	  <div class="container">
          <div class="content">
       <table  >
       <tr><td>Username</td></tr>
       <tr><td><input type=text name=username required=required placeholder=username></td></tr>
		<tr><td>Customer name 
		</td></tr><tr><td>
		<input type=text id="customer_firstname" name="customer_firstname" onfocusout="customer_firstnamefunction();" required="required" placeholder="first">&nbsp; &nbsp;&nbsp;&nbsp; 
		<input type=text name="customer_lastname" required="required" onfocusout="customer_lastnamefunction();" placeholder="last">
		<br><br></td></tr><tr><td>
		Customer address  </td></tr><tr><td>
		<textarea name="customer_address" rows=5 cols=40 placeholder="address" required=required height=150px>
		</textarea><tr><td>
		<br><br>
		Customer phone number  </td></tr><tr><td>
		<input type=text name="contact_number" required=required placeholder="contact"	 onfocusout="customer_contactfunction();" style= width:300px;height:29px;>
		<br><br></td></tr><tr><td>
		Customer email </td></tr><tr><td>
		 <input  type=email name="customer_email" required=required placeholder="email id" >
		<br><br></td></tr><tr><td>
		Customer gender </td></tr><tr><td>
		<select name="customer_gender">
			<option >Select gender </option>
			<option value="male">Male</option>
			<option value="male">Female</option>
			<option value="other">Other</option>
			</select><br><BR></td></tr><tr><td>
			
			<button type="submit" class="btn btn-default">Submit</button><br><BR><BR></td></tr>
	</table><br><BR><BR><BR><BR><BR><br><BR><BR><BR><BR><BR><BR><BR><br><BR><BR><BR><BR>
	</div></div>
</div>
</form>
</body>
</html>
       