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

public class ListProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		showList(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		showList(req, resp);
	}
	
	private void showList(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		req.setAttribute("products", SupProductDao.getAllProducts());
		RequestDispatcher rd = req.getRequestDispatcher("/listProduct.jsp");
		rd.forward(req, resp);
	}

}
