<%@page import="org.jsp.userproductapp.dto.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% User user=(User)session.getAttribute("user");
	if(user!=null)
	{%>
	<h2>Welcome Mr. <%=user.getName() %></h2>
	<h3>
	<a href="editUser.jsp">Edit your profile</a>
	</h3>
	<h3>
	<a href="viewUser.jsp">View your profile</a>
	</h3>
	<h3>
	<a href="delete">Delete your profile</a>
	</h3>
	<h3>
	<a href="logout">Logout</a>
	</h3>
	<h3>
	<a href="addProduct.jsp">Add Products</a>
	</h3>
	<h3>
	<a href="viewproducts">View Products</a>
	</h3>
	<%
	}else
	{
		response.sendRedirect("login.jsp");
	}
	 %>

</body>
</html>