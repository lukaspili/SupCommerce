<%@page import="com.supinfo.sun.supcommerce.exception.UnknownProductException"%>
<%@page import="com.supinfo.sun.supcommerce.doa.SupProductDao"%>
<%@page import="com.supinfo.sun.supcommerce.bo.SupProduct"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SupCommerce - Détail d'un produit</title>
</head>
<body>

<% String idParam = request.getParameter("id"); %>

<% long id = 0;

try {
	id = Long.valueOf(idParam);
} catch (NumberFormatException e) {
	response.sendRedirect("listProduct.jsp");
	return;
} %>


<% SupProduct product = null;

try {
	product = SupProductDao.findProductById(id);
} catch (UnknownProductException e) {
	response.sendRedirect("listProduct.jsp");
	return;
} %>

<%@ include file="/template/header.jsp" %>

<h2><%= product.getName() %></h2>

<p>
	<%= product.getContent() %> <br />
	<%= product.getPrice() %> euros <br />
</p>

<%@ include file="/template/footer.jsp" %>

</body>
</html>