<html>
<title>Search Employee</title>
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
	<h4>Search Employee Details By One of the Following:</h4>
	
		<form action = "EmployeeControllerServlet" method = "GET">
		
		<input type = "hidden" name = "command" value = "SEARCH">	
		
		<!-- <input type="radio" id="EmployeeID" name="EmployeeID" value="EmployeeID"> 
		<label for="EmployeeID">Employee ID</label>
		
		<input type="radio" id="lastName" name="lastName" value="LastName"> 
		<label for="LastName">Last Name</label>
		
		<input type="radio" id="jobTitle" name="jobTitle" value="jobTitle"> 
		<label for="jobTitle">Job Title</label>
		
		<input type="radio" id="reportsTo" name="reportsTo" value="reportsTo"> 
		<label for="reportsTo">Reporting To</label> -->
		
		<table>
		<tbody>
		
		<tr>	
			<td><label for = EmployeeID>Employee ID:</label></td>
			<td><input type = "text" id = "EmployeeID" name = "EmployeeID"></td>
		</tr>
		<tr>
			<td><label for = "lastName">Last Name:</label></td>
			<td><input type = "text" id = "lastName" name = "lastName"></td>
		</tr>
		<tr>
			<td><label for = "jobTitle">Job Title:</label></td>
			<td><input type = "text" id = "jobTitle" name = "jobTitle"></td>
		</tr>
		<!-- <tr>
			<td><label for = "report">Reporting To:</label></td>
			<td><input type = "text" id = "report" name = "report"></td>
		</tr> -->
		<tr>
			<td><label for = "from">Salary Range From:</label></td>
			<td><input type = "text" id = "from" name = "from"></td>
			
			<td><label for = "to" id = "to">to</label></td>
			<td><input type = "text" id = "to" name = "to"></td>
		</tr>
		<tr>
			<td></td>
			<td><input type = "submit" value = "Search"></td>
		</tr>	
		
		</tbody>
		</table>
			
		
		</form>
		
		<a href = "EmployeeControllerServlet">Back to List</a>
	</div>
	

</div>


</body>




</html>