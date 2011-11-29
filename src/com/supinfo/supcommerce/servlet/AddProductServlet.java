package com.supinfo.supcommerce.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.sun.supcommerce.bo.SupProduct;
import com.supinfo.sun.supcommerce.doa.SupProductDao;

public class AddProductServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name").trim();
		String content = req.getParameter("content").trim();
		float price = 0;
		
		try {
			price = Float.valueOf(req.getParameter("price"));
		} catch (NumberFormatException e) {
			showError(req, resp);
			return;
		}
		
		if(name.isEmpty() || content.isEmpty() || price == 0) {
			showError(req, resp);
			return;
		}
		
		SupProduct product = new SupProduct();
		product.setName(name);
		product.setContent(content);
		product.setPrice(price);
		
		SupProductDao.addProduct(product);
		
		resp.sendRedirect(req.getContextPath() + "/showProduct?id=" + product.getId());
	}

	private void showError(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isErrors", true);
		RequestDispatcher rd = req.getRequestDispatcher("addProduct.jsp");
		rd.forward(req, resp);
	}
}
