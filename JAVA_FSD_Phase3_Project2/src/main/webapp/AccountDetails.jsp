<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body background=
"https://media.geeksforgeeks.org/wp-content/uploads/rk.png">
<%int price=Integer.parseInt(request.getParameter("price")); %>
<center>
<h1>Please fill below details to buy the item</h1>
<form action="accountcheck">
<table>
<tr><td>Account Number</td><td> <input type="text" name="AccountNumber"></td></tr><br>

<tr><td>Account holder Name</td><td><input type="text" name="AccountHolderName"></td><br>

<tr>

<td>Account Password</td><td><input type="password" name="Password"></td>
<td><input type="hidden" name="price" value="<%=price%>"></td>


</tr>

</table>
<input type="submit">
</form>


<br>

<img alt="Failed to load an image" src="/images/shoepng2.png" style="width: 250px; height: 250px;">

</center>


</body>
</html>