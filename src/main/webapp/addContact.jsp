<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Phonebook</title>
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
	<div class="container-fluid">
		<div class="row p-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-success">Add Contact</h3>
						<%
						String saveSuccess = (String) session.getAttribute("saveSuccess");
						if (saveSuccess != null) {
						%>
						<p class="text-success text-center">
							<%=saveSuccess%>
						</p>
						<%
						session.removeAttribute("saveSuccess");
						}

						String saveFailed = (String) session.getAttribute("saveFailed");
						if (saveFailed != null) {
						%>
						<p class="text-danger text-center">
							<%=saveFailed%>
						</p>
						<%
						session.removeAttribute("saveFailed");
						}
						%>
						<form action="addContact" method="post">
							<%
							if (user != null) {
							%>
							<input type="hidden" value="<%=user.getId()%>" name="userId">
							<%
							}
							%>
							<div class="form-group">

								<label for="exampleInputEmail1">Name</label> <input name="name"
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Contact Number</label> <input
									name="phone" type="number" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									name="email" type="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<textarea name="about" rows="3" cols=""
									placeholder="Enter About" class="form-control"></textarea>
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-success">Save
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