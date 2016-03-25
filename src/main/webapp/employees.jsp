<%@page import="dbconnection.*" %>
<%@page import="employee.*" %>
<%@page import="java.util.*" %>


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
<%
	Connection con = new DBConnection(new JDBCConnection());
	EmployeeFactory ef = new EmployeeFactory();
	HashMap<Integer, Employee> hash = null;
	
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	

	if(con.connect(username, password)){
		hash = ef.employeeRsToHash(con.query("SELECT * FROM employees"));
	}else{
	   String site = new String("http://localhost:8080/CompApps/index.jsp");
	   response.setStatus(response.SC_MOVED_TEMPORARILY);
	   response.setHeader("Location", site); 
		
	}
%>

    <center>
	<table style="width:50%">
		<tr>
		<th>Employee ID</th>
		<th>Name</th>
		<th>Phone Number</th>
		<th>Supervisor</th>
		</tr>
		
		<% 
			if(con.getIsConnected() && !hash.equals(null)){
				for(Employee emp: hash.values()){ 
		%>
		
		<tr>
			<td><%=emp.getId() %>			</td>
			<td><%=emp.getName() %>			</td>
			<td><%=emp.getPhone() %>		</td>
			<td><%=emp.getSupervisor() %>	</td>
		</tr>
		<%
				}
			} 
		%>
	</table>
	</center>


</body>
</html>