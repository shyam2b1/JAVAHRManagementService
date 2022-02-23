<html>
<title>Add New Employee</title>
<head>
	<link rel = "stylesheet" href = "css/style.css">
	<link rel = "stylesheet" href = "css/add-employee-style.css">

</head>
<body>
<div id = "wrapper">
	<div id = "header">
		<h2><a href = "EmployeeControllerServlet">HR Reporting Service</a></h2>
	</div>
</div>

<div id = "container">
	<div id = "content">
	<h3>Add a New Employee</h3>
	<hr>
		<form action = "EmployeeControllerServlet" method = "GET">
		<input type = "hidden" name = "command" value = "ADD">
		<table>
		<tbody>
		<tr>	
			<td><label for = "firstName">First Name:</label></td>
			<td><input type = "text" id = "firstName" name = "firstName"></td>
		</tr>
		<tr>
			<td><label for = "lastName">Last Name:</label></td>
			<td><input type = "text" id = "lastName" name = "lastName"></td>
		</tr>
		<tr>
			<td><label for = "email">Email:</label></td>
			<td><input type = "text" id = "email" name = "email"></td>
		</tr>
		<tr>
			<td><label for = "jobTitle">Job Title:</label></td>
			<td><input type = "text" id = "jobTitle" name = "jobTitle"></td>
		</tr>
		<tr>
			<td><label for = "report">Reports To:</label></td>
			<td><input type = "text" id = "report" name = "report"></td>
		</tr>
		<tr>
			<td><label for = "salary">Salary:</label></td>
			<td><input type = "text" id = "salary" name = "salary"></td>
		</tr>
		<tr>
			<td></td>
			<td><input type = "submit" value = "Save"></td>
		</tr>	
		
		</tbody>
		</table>
			
		
		</form>
		
		<a href = "EmployeeControllerServlet">Back to List</a>
	</div>
	

</div>


</body>


</html>