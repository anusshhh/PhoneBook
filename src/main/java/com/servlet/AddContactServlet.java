package com.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.DbConnection;
import com.dao.ContactDAO;
import com.entity.Contact;

@WebServlet("/addContact")
public class AddContactServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int userId=Integer.parseInt(request.getParameter("userId"));
		String name=request.getParameter("name");
		long phone=Long.parseLong(request.getParameter("phone")); 
		String email=request.getParameter("email");
		String about=request.getParameter("about");
		
		Contact contact=new Contact(name,email,about,phone,userId);
		ContactDAO dao=new ContactDAO(DbConnection.jdbcConnection());
		boolean flag=dao.saveContact(contact);
		HttpSession session=request.getSession();
		if(flag==true) {
			session.setAttribute("saveSuccess", "Contact Saved Successfully.");
			response.sendRedirect("addContact.jsp");
		}else {
			session.setAttribute("saveFailed", "Something went wrong.");
			response.sendRedirect("addContact.jsp");
			
		}
	}

}
