package com.supinfo.supcommerce.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcommerce.entity.Category;
import com.supinfo.supcommerce.entity.Product;

public class AddProductServlet extends HttpServlet {
	
	private EntityManagerFactory emf;
	
	@Override
	public void init() throws ServletException {
		emf = Persistence.createEntityManagerFactory("PU");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT c FROM Category AS c");
		
		List<Category> categories = query.getResultList();
		
		req.setAttribute("categories", categories);
		
		RequestDispatcher rd = req.getRequestDispatcher("/auth/addProduct.jsp");
		rd.forward(req, resp);
	}
	
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
		
		long categoryId;
		try {
			categoryId = Long.valueOf(req.getParameter("category"));
		} catch (NumberFormatException e) {
			showError(req, resp);
			return;
		}
		
		Product product = new Product();
		product.setName(name);
		product.setContent(content);
		product.setPrice(price);
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Category category = em.find(Category.class, categoryId);
		product.setCategory(category);
		
		em.persist(product);
		em.getTransaction().commit();
		em.close();
		
		resp.sendRedirect(req.getContextPath() + "/showProduct?id=" + product.getId());
	}

	private void showError(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isErrors", true);
		RequestDispatcher rd = req.getRequestDispatcher("addProduct.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	public void destroy() {
		emf.close();
	}
}
