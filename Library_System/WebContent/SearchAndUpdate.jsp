<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="Header.jsp" %>
<!DOCTYPE html>
<html>
<title>Search and Update Member</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" type="text/css" href="UpdateMember.css">


<body >
       <script type="text/javascript" src=UpdateMember.js>
	
</script>
<h1 align=center>Member </h1>
           <form method="post" action="UpdateMember" name="update">
           <table>
           <tr><td><br>Enter User name</td></tr>
       <tr><td><input type=text name=username  id=username placeholder=username required=required onfocusout="{getUser();}">
       <hr><hr></td></tr>
       <tr><td>Full name</td></tr>
       <tr><td><input type=text name=name  id=name placeholder=name readonly ></td></tr>
           	<tr><td><br>Customer address  </td></tr><tr><td>
		<input type=text id="customer_address" name="customer_address" placeholder="address"   >
		</td></tr>
		<tr><td>
		<br><br>
		Customer phone number  </td></tr><tr><td>
		<input type=text id="contact_number" name="contact_number" placeholder="contact" onfocusout="customer_contactFunction();" >	
		<br><br></td></tr><tr><td>
		Customer email </td></tr><tr><td>
		 <input  type=email id="customer_email" name="customer_email"  placeholder="email id"  >
		<br><br></td></tr><tr><td>	
		 	<tr><td>Customer Gender </td></tr><tr><td>
		<input type=text id="customer_gender" name="customer_gender" placeholder="gender" readonly   >
		</td></tr><tr><td>
        <input type=submit name=update_member value="Update Member" >
           	</td></tr>
           	</table>
           </form>
          
        </div>
	</div>
</body>
</html>