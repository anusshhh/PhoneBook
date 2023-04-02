package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.DbConnection;
import com.dao.ContactDAO;
import com.entity.Contact;

@WebServlet("/editContact")
public class EditServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int cid=Integer.parseInt(request.getParameter("cid"));
		String name = request.getParameter("name");
		long phone = Long.parseLong(request.getParameter("phone"));
		String email = request.getParameter("email");
		String about = request.getParameter("about");

		Contact contact = new Contact(cid,name, email, about, phone);
		ContactDAO dao = new ContactDAO(DbConnection.jdbcConnection());
		boolean f = dao.updateContact(contact);
		HttpSession session = request.getSession();
		if (f) {
			session.setAttribute("successMsg", "Update Successful");
			response.sendRedirect("viewContact.jsp");

		} else {
			session.setAttribute("failedMsg", "Update Failed");
			response.sendRedirect("edit.jsp?cid=" + cid);

		}

	}

}
