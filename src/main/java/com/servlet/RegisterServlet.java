package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.DbConnection;
import com.dao.UserDAO;
import com.entity.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User u = new User(name, email, password);
		UserDAO dao = new UserDAO(DbConnection.jdbcConnection());
		boolean flag = dao.userRegister(u);
		HttpSession s=request.getSession();
		if (flag) {
			s.setAttribute("successMsg", "Registration Successful");
			response.sendRedirect("register.jsp");
		}
		else
		{
		    s.setAttribute("errorMsg","Registration Failed");
			response.sendRedirect("register.jsp");
		}
	}

}
