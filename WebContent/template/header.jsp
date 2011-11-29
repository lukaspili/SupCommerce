<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h1>
	<a href="<%= application.getContextPath() %>"> SupCommerce - Site
		de vente en ligne !</a>
</h1>

<p>
	<a href="<%= application.getContextPath() %>/listProduct">Liste des produits</a> |

	<% if(session.getAttribute("login") != null) { %>
		<a href="<%= application.getContextPath() %>/auth/addProduct.jsp">Nouveau produit</a> |
		<a href="<%= application.getContextPath() %>/logout">Déconnexion</a>
	<% } else { %>
		<a href="<%= application.getContextPath() %>/login.html">Connexion</a>
	<% } %>
</p>