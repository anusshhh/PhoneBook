<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<%@include file="components/allCss.jsp"%>
</head>
<body>
	<%@include file="components/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row p-5">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-success">Login</h3>
						<%
						String successLogout = (String) session.getAttribute("successLogout");
						if (successLogout != null) {
						%>
                        <p class="text-success text-center">
							<%=successLogout%>
						</p>
						<%
						session.removeAttribute("successLogout");
						}
						
						String invalidMsg = (String) session.getAttribute("invalidMsg");
						if (invalidMsg != null) {
						%>
						<p class="text-danger text-center">
							<%=invalidMsg%>
						</p>
						<%
						session.removeAttribute("invalidMsg");
						}
						%>
						<form action="login" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									name="email" type="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									name="password" type="password" class="form-control"
									id="exampleInputPassword1">
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-success">Login</button>
							</div>


						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="margin-top: 195px">
		<%@include file="components/footer.jsp"%>
	</div>
</body>
</html>