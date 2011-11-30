package com.supinfo.supcommerce.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcommerce.entity.Category;

public class AddCategoryServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Category category = new Category();
		category.setName(req.getParameter("name"));
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(category);
		em.getTransaction().commit();
		
		resp.sendRedirect(req.getContextPath() + "/listProduct");
	}

}
