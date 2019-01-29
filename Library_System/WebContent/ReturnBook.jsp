<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Return book</title>
<link rel="stylesheet" type="text/css" href="ReturnBook.css">

<script type="text/javascript" src="ReturnBook.js">
	</script></head>


<body >
<h1 align=center>Return Book</h1>
       <form action="ReturnBook" method="post">
      		<table>
		<tr><td>Username
		</td></tr><tr><td>
		<input type=text name="username" required="required" id="username" placeholder="username">
		<br><br></td></tr><tr><td>
		Book ID</td></tr><tr><TD>
		<input type=text name="book_id" id="book_id" required=required onfocusout="getIssueDate();" placeholder="book id" ><br><br></TD></tr><tr><td>
		<tr><td>
		Date of issue</td></tr><tr><td>
	<input id="issue_date" type="text" name="date_of_issue"  style="height:25px,width:200px">
	<br><BR>
	</td></tr>
	<tr><td>
		Date of return</td></tr><tr><td>
	<input id="today" type="date" name="return_date" onfocus="date_take();" style="height:25px,width:200px">
	<br><BR>
	</td></tr>
	
       <tr><td>
       <input type=submit name="return_book" value="Return Book">
       </td></tr></table>
       </form>
       </div></div>
</body>
</html>