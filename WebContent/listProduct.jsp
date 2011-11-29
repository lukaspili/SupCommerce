<%@page import="com.supinfo.sun.supcommerce.doa.SupProductDao"%>
<%@page import="com.supinfo.sun.supcommerce.bo.SupProduct"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SupCommerce - Liste des produits</title>
</head>
<body>

<%@ include file="/template/header.jsp" %>

<h2>Liste des produits</h2>

<% for(SupProduct product : SupProductDao.getAllProducts()) { %>

<p>
	<strong><%= product.getName() %></strong> <br />
	<%= product.getContent() %> <br />
	<%= product.getPrice() %> euros <br />
	<a href="showProduct.jsp?id=<%= product.getId() %>">Voir en détail</a>
	
	<% if(session.getAttribute("login") != null) { %>
		<br />
		<form method="post" action="<%= application.getContextPath() %>/auth/removeProduct">
			<input type="hidden" name="id" value="<%= product.getId() %>"/>
			<input type="submit" value="Supprimer ce produit">
		</form>
	<% } %>
</p>

<% } %>

<%@ include file="/template/footer.jsp" %>

</body>
</html>