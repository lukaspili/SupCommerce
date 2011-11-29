package com.supinfo.supcommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
	
	private void showList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		out.println("<h1>Liste des produits</h1>");

		out.println("<p><a href=\"auth/basicInsert\">Ajouter un nouveau produit</a></p>");

		for (SupProduct product : SupProductDao.getAllProducts()) {
			out.println("<p>");
			out.println("Name : <a href=\"showProduct?id=" + product.getId() + "\">" + product.getName() + "</a><br />");
			out.println("Content : " + product.getName() + "<br />");
			out.println("Price : " + product.getName());
			out.println("</p>");
		}
	}

}
