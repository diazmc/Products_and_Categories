<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product Page</title>
</head>
<body>
	<h1>${product.name }</h1>
	
	<h3>Categories</h3>
	
	<ul>
		<c:forEach items="${product.categories}" var="pc">
				<li>${pc.name}</li>
		</c:forEach>	
	</ul>
	
	<form method='POST' action='/add/category'>
		<input type='hidden' value='${product.id }' name="product_id">
		<label>Add Category</label>
		<select name="category_id">
			<c:forEach items="${categories}" var="c">
				<option value="${c.id}">${c.name}</option>
			</c:forEach>		
		</select><br><br>
		
		<input type='submit' value='Add'>
	</form>

</body>
</html>