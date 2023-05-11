<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="addproducts" method="post">
		Name<input type="text" name="nm"><br> 
		Description<input type="text" name="desc"><br> 
		Category<input type="text" name="cat"><br> 
		Brand<input type="text" name="br"><br>
		Image<input type="text" name="im"><br>
		Price<input type="number" name="price"><br> 
		<input type="submit" value="Add Product">

	</form>

</body>
</html>