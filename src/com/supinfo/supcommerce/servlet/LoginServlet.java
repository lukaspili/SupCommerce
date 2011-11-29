package com.supinfo.supcommerce.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	private static final String LOGIN = "foo";
	private static final String PASSWORD = "bar";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String login = req.getParameter("login");
		String password = req.getParameter("password");

		if (!LOGIN.equalsIgnoreCase(login) || !PASSWORD.equals(password)) {
			resp.sendRedirect("login.html");
			return;
		}
		
		req.getSession().setAttribute("login", login);
		
		resp.sendRedirect(req.getContextPath());
	}

}
