<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="Header.jsp" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Issue Book</title>
<link rel="stylesheet" type="text/css" href="issueBook.css">
<script type="text/javascript">
	function date_take(){
		let today = new Date().toISOString().substr(0, 10);
		document.querySelector("#today").value = today;}</script>
		
<body >
<h1 align=center>Issue Book	</h1>
<form action="IssueBook" method="post">
      	<table>
		<tr><td>Username
		</td></tr><tr><td>
		<input type=text name="username" required="required" placeholder="username">
		<br><br></td></tr><tr><td>
		Book ID</td></tr><tr><TD>
		<input type=text name="book_id" required=required placeholder="book id"><br><br></TD></tr><tr><td>
		Date of issue</td></tr><tr><td>
	<input id="today" type="date" name="date_of_issue" onclick="date_take();" style="height:25px,width:200px">
	<br><BR>
	</td></tr>
       <tr><td>
       <input type=submit name="issue_book" value="Issue Book">
       </td></tr></table>
       </form>
       </div></div>
</body>
</html>