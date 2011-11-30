package com.supinfo.supcommerce.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveProductServlet extends HttpServlet {
	
	private EntityManagerFactory emf;
	
	@Override
	public void init() throws ServletException {
		emf = Persistence.createEntityManagerFactory("PU");
	}

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

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("DELETE FROM Product WHERE id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
		em.getTransaction().commit();
		em.close();

		resp.sendRedirect(req.getContextPath() + "/listProduct.jsp");
	}

	@Override
	public void destroy() {
		emf.close();
	}
}
