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
<body>
<%List<ShoePojo> list=(List<ShoePojo>)request.getAttribute("list");%>
<table >
<%for(ShoePojo s:list){ %>
<form >


<tr><td><%=s.getId()%></td><td><img alt="Failed to load an image" src="/images/<%=s.getName()%>" style="width: 100px; height: 100px;"></p></td><td><br><p><%=s.getShoename() %></p><p><%=s.getDescription()%></td><br></tr>




</form>
<%} %>
</table>
<br>
<form action="addShoe.jsp">
<input type="submit" value="Add Shoe">

</form>
<br>
<form action="deleteshoe.jsp">
<input type="submit" value="Delete Shoe">

</form>

</body>
</html>