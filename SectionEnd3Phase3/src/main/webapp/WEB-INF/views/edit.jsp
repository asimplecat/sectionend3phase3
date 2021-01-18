<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit your entry</title>
</head>
<body>
	
		<form action="edit" method="post">
			
			<table border='1' style="width: 40%">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
		</tr>
		<tr style="text-align:center">
			<td>${user.getId()}</td>
			<td>${user.getName()}</td>
			<td>${user.getEmail()}</td>
		</tr>
	</table>
		<br>
		<br>
		<br>
		<h1>Edit:</h1>
		<br>
		<br>
		<h3>Change To This</h3>
			Id: <input type="text" name="id" value=${user.getId()} readonly="readonly">
			name : <input type="text" name="name" />
			email : <input type="text" name="email" /> 
			<input type="submit" value="save" />
	</form>
	
</body>
</html>
