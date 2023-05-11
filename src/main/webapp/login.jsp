<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String message = (String) request.getAttribute("msg");
	if (message != null) {
	%>
	<h2>
		<%=message%>
	</h2>
	<%
	}
	%>
	<form action="login" method="post">
		<label for="ph">Phone</label> <input type="tel" name="ph"><br>
		<label for="ps">Password</label> <input type="password" name="ps"><br>

		<input type="submit" value="LOGIN">

	</form>
	<h2>
		<a href="register.jsp">Click here to register</a>
	</h2>
</body>
</html>