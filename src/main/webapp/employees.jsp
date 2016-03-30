<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<title>Employees</title>
	<meta name="generator" content="Bootply" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
</head>
<body>
    <center>
	<table style="width:50%">
		<tr>
		<th>Employee ID</th>
		<th>Name</th>
		<th>Phone Number</th>
		<th>Supervisor</th>
		</tr>
		<c:forEach var="employee" items="${employees}">
			<tr>
				<td>${employee.value.id}</td>
				<td>${employee.value.name}</td>
				<td>${employee.value.phone}</td>
				<td>${employee.value.supervisor}</td>
			</tr>
		</c:forEach>
	</table>
	</center>
</body>
</html>