<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="insertLaptop">
		Enter Laptop Id - <input type="text"  name="lid"/> <br/>
		Enter Laptop Make - <input type="text"  name="make"/> <br/>
		Enter Laptop Cost - <input type="text"  name="cost"/> <br/>
		<input type="submit" value="Submit"/> <br />
	</form>
	<form action="showLaptop">
		<input type="submit" value="Show Details"/>
	</form>
</body>
</html>