<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register And Login</title>
</head>
<body>
	
	<form action="regform" method="post">
	NAME : <input type="text" name="name1"><br><br>
	EMAIL :<input type="text" name="email1"><br><br>
	PASS :<input type="password" name="pass1"><br><br>
	GENDER :<input type="radio" name="gender1" value="male">Male <input type="radio" name="gender1" value="female">Female<br><br>
	CITY : <select name="city1">
			<option>Select city<option/>
			<option>delhi<option/>
			<option>pune<option/>
			<option>mumbai<option/>
			<option>haridwar<option/>
	
		</select><br><br>
		<input type="submit" value="click me"/>
	
	</form>
	
</body>
</html>