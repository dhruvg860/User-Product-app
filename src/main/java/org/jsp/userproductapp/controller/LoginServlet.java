package org.jsp.userproductapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsp.userproductapp.dao.UserDao;
import org.jsp.userproductapp.dto.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			long phone = Long.parseLong(req.getParameter("ph"));
			String password = req.getParameter("ps");

			UserDao dao = new UserDao();
			User u = dao.verifyUser(phone, password);
			RequestDispatcher d = null;
			if (u != null) {
				System.out.println("Success");
				d = req.getRequestDispatcher("home.jsp");
				HttpSession session = req.getSession();
				session.setAttribute("user", u);
				d.forward(req, resp);
			} else {
				PrintWriter w = resp.getWriter();
				w.write("<html><body><h2> Invalid Phone or password </h2></body></html>");
				d = req.getRequestDispatcher("login.jsp");
				d.include(req, resp);
			}
		} catch (Exception e) {
			PrintWriter w = resp.getWriter();
			w.write("<html><body><h2> Exception </h2></body></html>");
			System.err.println("EEEEEEEEEXXXXXXXXXXX");
		}
	}
}
