<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SupCommerce - Nouvelle catégorie</title>
</head>
<body>

<%@ include file="/template/header.jsp" %>

<h2>Nouvelle catégorie</h2>

<form action="<%= application.getContextPath() %>/auth/addCategory" method="post">
	
	<label for="name">Name :</label>
	<input type="text" name="name" id="" />
	
	<input type="submit" value="Add" />
</form>

<%@ include file="/template/footer.jsp" %>

</body>
</html>