package com.supinfo.supcommerce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveProductServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idParam = req.getParameter("id");

		long id;

		try {
			id = Long.valueOf(idParam);
		} catch (NumberFormatException e) {
			resp.sendRedirect(req.getContextPath() + "/listProduct.jsp");
			return;
		}

		//SupProductDao.removeProduct(id);

		resp.sendRedirect(req.getContextPath() + "/listProduct.jsp");
	}

}
