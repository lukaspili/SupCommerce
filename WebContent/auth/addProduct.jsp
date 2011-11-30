<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SupCommerce - Ajouter un produit</title>
</head>
<body>

	<%@ include file="/template/header.jsp" %>

	<h1>Ajouter un produit</h1>
	
	<% if(request.getAttribute("isErrors") != null) { %>
		<p style="color:red">Des erreurs sont présentes sur le formulaire !</p>
	<% } %>

	<form action="<%= application.getContextPath() %>/auth/addProduct" method="POST">
		<p>
			<label for="name">Nom : </label> 
			<input type="text" id="name" name="name" />
		</p>

		<p>
			<label for="content">Contenu : </label> <br />
			<textarea id="content" name="content"></textarea>
		</p>

		<p>
			<label for="price">Prix : </label> 
			<input type="text" id="price" name="price" />
		</p>
		
		<p>
			<label for="category">Catégorie :</label>
			<select name="category">
				<c:forEach items="${categories}" var="c">
					<option value="${c.id}">${c.name}</option>
				</c:forEach>
			</select>
		</p>

		<p>
			<input type="submit" value="Add" />
		</p>
	</form>
	
	<%@ include file="/template/footer.jsp" %>

</body>
</html>