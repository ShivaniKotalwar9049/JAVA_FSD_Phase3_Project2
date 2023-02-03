<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:khaki;">
<center>
<form action="AddShoe" method="post" enctype="multipart/form-data"><br>




<table>

<tr><td>Name</td><td> <input type="text" name="shoename"><br></td><br></tr>
<tr><td>Description</td><td> <input type="text" name="desc"><br></td><br></tr>
<tr><td>Price</td><td> <input type="text" name="price"><br></td></tr>
<tr><td>Upload the image of shoe here</td><td> <input type="file" name="file"><br></td></tr>



</table>
<input type="submit">
</form>
</center>
</body>
</html>