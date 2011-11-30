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
import com.supinfo.supcommerce.entity.Product;

public class InsertSomeProductServlet extends HttpServlet {
	
	private EntityManagerFactory emf;
	
	@Override
	public void init() throws ServletException {
		emf = Persistence.createEntityManagerFactory("PU");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Product product = new Product();
		product.setName("Foo");
		product.setContent("Bar");
		product.setPrice(10);
		
		Category category = new Category();
		category.setName("Toto");
		
		product.setCategory(category);
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(category);
		em.persist(product);
		em.getTransaction().commit();
		em.close();
		
		resp.setContentType("text/html");
		resp.getWriter().println("Le produit a été ajouté !");
	}
	
	@Override
	public void destroy() {
		emf.close();
	}
	
	

}
