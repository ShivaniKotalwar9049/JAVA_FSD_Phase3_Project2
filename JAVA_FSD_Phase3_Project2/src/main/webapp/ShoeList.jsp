<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.example.demo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body background=
"https://media.geeksforgeeks.org/wp-content/uploads/rk.png">
<h1><i>Hi there, please have fun shopping.</i></h1>

<%List<ShoePojo> list=(List<ShoePojo>)request.getAttribute("list");%>
<%for(ShoePojo s:list){ %>
<form action="AccountDetails.jsp" method="get">
<table>

<tr>

<td><img alt="Failed to load an image" src="/images/<%=s.getName()%>" style="width: 100px; height: 100px;"></p></td><td><br><p>&nbsp&nbsp&nbsp&nbsp<%=s.getShoename() %></h3></h3></p><p>&nbsp&nbsp&nbsp&nbsp<%=s.getDescription()%></td>
<td>


<input type="hidden" name="price" value="<%=s.getPrice()%>">

<input type="submit" value="Buy">


</form>
</td>
</tr>


</table>

<%} %>

</body>
</html>