<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<link rel="stylesheet" type="text/css" href="Main.css">

</head>
<body>

<div class="navbar">
	<a class="home" href="Main.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Home&nbsp;&nbsp;&nbsp;&nbsp; </a>
  <div class="dropdown">
    <button class="dropbtn">Member
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="AddMember.jsp">Add Member</a>
      <a href="SearchAndUpdate.jsp">View Member</a>
      <a href="DeleteMember.jsp">Delete Member</a>
      
  </div>
   </div> 
   <div class="dropdown">
      <button class="dropbtn">Issue Book
      <i class="fa fa-caret-down"></i></button>
      <div class="dropdown-content">
        <a href="IssueBook.jsp"> Issue Book</a>
        <a href="ReturnBook.jsp"> Return Book</a>
     </div>
   </div>
   		<a class="ReportForAll" href="ReportForAll.jsp">&nbsp;&nbsp;Listing&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </a>
   		<a class="ReportAll" href="Report.jsp">&nbsp;&nbsp;&nbsp;&nbsp;Reports&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </a>
        <a class="reportsFilterBased" href="FilterBasedReports.jsp">&nbsp;Filter Based Reports&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </a>
        <a class =" about" href="About.jsp">&nbsp;&nbsp;About&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
        </div>
	    <div class="container">
	    <form method=post action=viewMember></form>
       <div class="content">
           
        </div>
	</div>
<hr>
</body>
</html>