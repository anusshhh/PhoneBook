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
@WebServlet("/login")

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String pass=request.getParameter("password");
		UserDAO dao = new UserDAO(DbConnection.jdbcConnection());
		User u= dao.userLogin(email, pass);
	    HttpSession session=request.getSession();
		if (u!=null) {
		session.setAttribute("user",u);
		response.sendRedirect("index.jsp");
		}
		else
		{
			session.setAttribute("invalidMsg","Invalid Email or Password.");
			response.sendRedirect("login.jsp"); 
		}
	}
	

}
