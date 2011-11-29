<%@page import="com.supinfo.sun.supcommerce.exception.UnknownProductException"%>
<%@page import="com.supinfo.sun.supcommerce.doa.SupProductDao"%>
<%@page import="com.supinfo.sun.supcommerce.bo.SupProduct"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SupCommerce - Détail d'un produit</title>
</head>
<body>

<%@ include file="/template/header.jsp" %>

<h2><c:out value="${product.name}" /></h2>

<p>
	<c:out value="${product.content}" /> <br />
	<c:out value="${product.price}" /> euros <br />
</p>

<%@ include file="/template/footer.jsp" %>

</body>
</html>