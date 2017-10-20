<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Category</title>
</head>
<body>

	<h1>New Category</h1>
	
	<form action='/categories/new' method='POST'> 
		<label>Name</label>
		<input type='text' name='name'><br><br>
		
		<input type='submit' value='Create'>
	
	</form>

</body>
</html>