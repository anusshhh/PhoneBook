<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.connection.DbConnection"%>
<%@page import="com.entity.Contact"%>
<%@page import="com.dao.ContactDAO"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contacts</title>
<%@include file="components/allCss.jsp"%>
<style type="text/css">
.crd-ho:hover {
	background-color: #f2f2f2;
}
</style>

</head>
<body>
	<%@include file="components/navbar.jsp"%>
	<%
	User user = (User) session.getAttribute("user");
	if (user == null) {
		response.sendRedirect("login.jsp");
	}

	String successMsg = (String) session.getAttribute("successMsg");
	if (successMsg != null) {
	%>
	<div class="alert alert-success text-center" role="alert"><%=successMsg%></div>
	<%
	session.removeAttribute("successMsg");
	}

	String deleteSuccess = (String) session.getAttribute("deleteSuccess");
	if (deleteSuccess != null) {
	%>
	<div class="alert alert-success text-center" role="alert"><%=deleteSuccess%></div>
	<%
	session.removeAttribute("deleteSuccess");
	}

	String deleteFailed = (String) session.getAttribute("deleteFailed");
	if (deleteFailed != null) {
	%>
	<div class="alert alert-danger text-center" role="alert"><%=deleteFailed%></div>
	<%
	session.removeAttribute("deleteFailed");
	}
	%>

	<div class="container">
		<div class="row p-4">

			<%
			if (user != null) {
				ContactDAO dao = new ContactDAO(DbConnection.jdbcConnection());
				List<Contact> list = dao.viewContacts(user.getId());
				for (Contact c : list) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body">
						<h5>
							<b>Name:</b>
							<%=c.getName()%></h5>
						<p>
							<b>Email:</b>
							<%=c.getEmail()%></p>
						<p>
							<b>Contact Number:</b>
							<%=c.getPhone()%></p>
						<p>
							<b>About:</b>
							<%=c.getAbout()%></p>

						<div class="text-center">
							<a class="btn btn-success btn-sm text-white"
								href="edit.jsp?cid=<%=c.getId()%>">Edit</a> <a
								class="btn btn-danger btn-sm text-white"
								href="deleteContact?cid=<%=c.getId()%>">Delete</a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			}
			%>



		</div>
	</div>
</body>
</html>