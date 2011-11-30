package com.supinfo.supcommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.sun.supcommerce.bo.SupProduct;
import com.supinfo.sun.supcommerce.doa.SupProductDao;
import com.supinfo.sun.supcommerce.exception.UnknownProductException;

public class ShowProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String idParam = req.getParameter("id");

		long id;

		try {
			id = Long.valueOf(idParam);
		} catch (NumberFormatException e) {
			resp.sendRedirect(req.getContextPath() + "/listProduct");
			return;
		}

		SupProduct product;

		try {
			product = SupProductDao.findProductById(id);
		} catch (UnknownProductException e) {
			resp.sendRedirect(req.getContextPath() + "/listProduct");
			return;
		}

		req.setAttribute("product", product);
		RequestDispatcher rd = req.getRequestDispatcher("/showProduct.jsp");
		rd.forward(req, resp);
	}

}
