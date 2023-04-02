<%@page import="com.connection.DbConnection"%>
<%@page import="com.entity.User"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Phonebook App</title>
<%@include file="components/allCss.jsp"%>

<style type="text/css">
.back-img {
	background: url("img/background.jpg");
	width: 100%;
	height: 80vh;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>

</head>
<body>
	<%@include file="components/navbar.jsp"%>
	

	<div class="container-fluid back-img text-center text-success">
		<h1>Phonebook Project</h1>
	</div>
	<%@include file="components/footer.jsp"%>


</body>
</html>