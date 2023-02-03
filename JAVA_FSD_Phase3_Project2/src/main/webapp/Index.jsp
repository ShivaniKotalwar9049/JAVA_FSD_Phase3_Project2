<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sporty Shoes</title>
</head>
<body style="background-color:khaki;">
<center>
<h1>Welcome to Sporty shoes. Please login or Register</h1>
<form action="LoginCheck">
<table>
<tr><td>UserName</td><td> <input type="text" name="UserName"></td></tr><br>

<tr><td>Password </td><td><input type="password" name="Password"></td></tr><br>
</table>
<br>
<input type="submit"><br>
<br>
<a href="http://localhost:8081/UserRegistration.jsp">Register if account is not yet created</a>
</form>

</center>

<center>
<div>

<form action="AdminLogin">
<br>
<br>
<br>
<a href="http://localhost:8081/AdminLogin.jsp">Click here for AdminLogin</a>
</form>

</div>
</center>
</body>
</html>