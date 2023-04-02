<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.connection.DbConnection"%>
<%@page import="com.entity.Contact"%>
<%@page import="com.dao.ContactDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Contact</title>
<%@include file="components/allCss.jsp"%>
</head>
<body>
	<%@include file="components/navbar.jsp"%>
	<%
	User user = (User) session.getAttribute("user");
	if (user == null) {
		response.sendRedirect("login.jsp");
	}
	%>
	r
	<div class="container-fluid">
		<div class="row p-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-success">Edit Contact</h3>

						<form action="editContact" method="post">
							<%
							String failedMsg = (String) session.getAttribute("failedMsg");
							if (failedMsg != null) {
							%>
							<p class="text-danger text-center">
								<%=failedMsg%>
							</p>
							<%
							session.removeAttribute("failedMsg");
							}
							%>
							
							<%
							int cid = Integer.parseInt(request.getParameter("cid"));
							ContactDAO dao = new ContactDAO(DbConnection.jdbcConnection());
							Contact c = dao.getContact(cid);
							%>

							<input type="hidden" value="<%=cid%>" name="cid">
							<div class="form-group">
								<label for="exampleInputEmail1">Name</label> <input
									value="<%=c.getName()%>" name="name" type="text"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Contact Number</label> <input
									value="<%=c.getPhone()%>" name="phone" type="number"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									value="<%=c.getEmail()%>" name="email" type="email"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<textarea name="about" rows="3" cols=""
									placeholder="Enter About" class="form-control"><%=c.getAbout()%></textarea>
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-success">Update
									Contact</button>
							</div>


						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>