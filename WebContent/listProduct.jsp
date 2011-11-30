<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SupCommerce - Liste des produits</title>
</head>
<body>

<%@ include file="/template/header.jsp" %>

<h2>Liste des produits</h2>



<c:forEach items="${products}" var="p">
<p>
	<strong>
		<c:out value="${p.name}" />
	</strong> <br />
	<c:out value="${p.content}" /> <br />
	
	<c:out value="${p.price}" /> euros <br />
	
	<a href="showProduct?id=${p.id}">Voir en détail</a>
	
	<c:if test="${!empty login}">
		<br />
		<form method="post" action="<%= application.getContextPath() %>/auth/removeProduct">
			<input type="hidden" name="id" value="${p.id}"/>
			<input type="submit" value="Supprimer ce produit">
		</form>
	</c:if>
</c:forEach>

<%@ include file="/template/footer.jsp" %>

</body>
</html>