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

@WebServlet("/deleteContact")
public class DeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cid = Integer.parseInt(request.getParameter("cid"));
		ContactDAO dao = new ContactDAO(DbConnection.jdbcConnection());
		boolean f = dao.deleteContact(cid);
		HttpSession session = request.getSession();
		if (f) {
			session.setAttribute("deleteSuccess", "Contact Deleted");
			response.sendRedirect("viewContact.jsp");

		} else {
			session.setAttribute("deleteFailed", "Delete Failed");
			response.sendRedirect("viewContact.jsp");

		}

	}
}
