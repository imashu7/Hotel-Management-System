<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin-Home</title>
<link rel="stylesheet" href="login.css">
</head>
<style>
.loginbox form
{
	text-align:center;
	padding-top: 27px;
}
body{
background-image: url('https://images.unsplash.com/photo-1561501900-3701fa6a0864?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8bHV4dXJ5JTIwaG90ZWx8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80');
background-repeat: no-repeat;
background-size: 1500px 1200px;
}
</style>
</style>
<body>
<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");	//http 1.1
	response.setHeader("pragma","no-cache");	//http 1.0
	response.setHeader("Expires","0");		//proxies

	if(session.getAttribute("uID")==null)
	{
		response.sendRedirect("login.html");
	}
%>

<div class="loginbox">
<h1>Hotel Management</h1>
<h1>Welcome Admin</h1>

        
<form action="AdminHotels"><button type="button" class="cancelbtn"><a href="ShowHotels" style="color: black">Hotels</a></button></form>
<form action="AdminUsers"><button type="button" class="cancelbtn"><a href="Users.html" style="color: black">Users</a></button></form>
<form action="AdminCustomers"><button type="button" class="cancelbtn"><a href="Customers.html" style="color: black">Customers</a></button></form>
<form action="AdminBookings"><button type="button" class="cancelbtn"><a href="Bookings.html" style="color: black">Bookings</a></button></form>
<form action="AdminEmployee"><button type="button" class="cancelbtn"><a href="Employees.html"style="color: black">Employees</a></button></form>       
<form action="logout"><button type="submit">Logout</button></form>      
     
</div> 
                
      


</body>
</html>