<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Category Page</title>
</head>
<body>
	<h1>${category.name}</h1>
	
	<h3>Products:</h3>
	
	<ul>
		<c:forEach items="${category.products}" var="cp">
				<li>${cp.name}</li>
		</c:forEach>	
	</ul>
	
	<form action='/add/product' method='POST'>
		<input type="hidden" value="${category.id }" name="category_id">
		<label>Add Product:</label>
		<select name="product_id">
			<c:forEach items="${products}" var="p">
					<option value="${p.id}">${p.name}</option>			
			</c:forEach>
		</select><br><br>
		
		<input type='submit' value='Add'>
	</form>
	

</body>
</html>