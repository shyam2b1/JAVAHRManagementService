<%@page import = "com.scs.employee.model.*, java.util.*" %>

<html>
<title>Update an Employee</title>
<head>
	<link rel = "stylesheet" href = "css/style.css">
	<link rel = "stylesheet" href = "css/add-employee-style.css">

</head>
<body>
<div id = "wrapper">
	<div id = "header">
		<h2>HR Reporting Service</h2>
	</div>
</div>

<div id = "container">
	<div id = "content">
	<h3>Update an Employee</h3>
	<hr>
		<form action = "EmployeeControllerServlet" method = "GET">
		<input type = "hidden" name = "command" value = "UPDATE">
		<input type = "hidden" name = "employeeIdValue" value = "${THE_EMPLOYEE_LIST.employeeId}">
		<table>
		<tbody>
		<tr>
				
			<td><label for = "firstName">First Name:</label></td>
			<td><input type = "text" id = "firstName" name = "firstName" value = "${THE_EMPLOYEE_LIST.firstName}"></td>
		</tr>
		<tr>
			<td><label for = "lastName">Last Name:</label></td>
			<td><input type = "text" id = "lastName" name = "lastName" value = "${THE_EMPLOYEE_LIST.lastName}"></td>
		</tr>
		<tr>
			<td><label for = "email">Email:</label></td>
			<td><input type = "text" id = "email" name = "email" value = "${THE_EMPLOYEE_LIST.email}"></td>
		</tr>
		<tr>
			<td><label for = "jobTitle">Job Title:</label></td>
			<td><input type = "text" id = "jobTitle" name = "jobTitle" value = "${THE_EMPLOYEE_LIST.jobTitle}"></td>
		</tr>
		<tr>
			<td><label for = "report">Reports To:</label></td>
			<td><input type = "text" id = "report" name = "report" value = "${THE_EMPLOYEE_LIST.reportsTo}"></td>
		</tr>
		<tr>
			<td><label for = "salary">Salary:</label></td>
			<td><input type = "text" id = "salary" name = "salary" value = "${THE_EMPLOYEE_LIST.salary}"></td>
		</tr>
		<tr>
			<td></td>
			<td><input type = "submit" value = "Update"></td>
		</tr>	
		
		</tbody>
		</table>
			
		
		</form>
		
		<a href = "EmployeeControllerServlet">Back to List</a>
	</div>
	

</div>


</body>


</html>