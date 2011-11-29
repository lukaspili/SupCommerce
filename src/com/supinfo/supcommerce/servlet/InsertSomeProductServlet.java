package com.supinfo.supcommerce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.sun.supcommerce.bo.SupProduct;
import com.supinfo.sun.supcommerce.doa.SupProductDao;

public class InsertSomeProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SupProduct product = new SupProduct();
		product.setName("Foo");
		product.setContent("Bar");
		product.setPrice(10);
		
		SupProductDao.addProduct(product);
		
		resp.setContentType("text/html");
		resp.getWriter().println("Le produit a été ajouté !");
	}
	
	

}
