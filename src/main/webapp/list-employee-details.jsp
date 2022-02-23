<%@ page import = "java.util.*, com.scs.employee.model.*" %>

<html>
<% List <Employee> theEmployeeList = (List<Employee>)request.getAttribute("EMPLOYEE_LIST");

%>

<body>
<head>
	<link rel = "stylesheet" href = "css/style.css">
	<!-- <link rel = "stylesheet" href = "css/add-employee-style.css"> -->

</head>
	<div id = "wrapper">
		<div id = "header">
			<h2><a href = "EmployeeControllerServlet">HR Reporting Service</a></h2>
		</div>
	
	</div>
	
	<div id = "container">
		<div id = "content">
			<!-- <h3><a href = "add-new-employee-page.jsp">Add a New Employee</a></h3><br> -->
			
			<form action="add-new-employee-page.jsp">
				<input type = "button" value = "Add Employee" onclick = "window.location.href = 'add-new-employee-page.jsp'; return false;" class = "add-employee-button"/>
				
				<input type = "button" value = "Search an Employee" onclick = "window.location.href = 'search-employee-page.jsp'; return false;" class = "add-employee-button"/>
			</form>
			
			<table>
				<tr>
					<th>Employee Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Job Title</th>
					<th>Reports To</th>
					<th>Salary</th>
					<th>Action</th>
				</tr>
				
				<%! String commandValue = "LOAD"; %>
				<%! String deleteCommandValue = "DELETE"; %>
				
				<% for(Employee employee: theEmployeeList){
					int employeeIdValue = employee.getEmployeeId();
					%>
				
				<tr>
					<td><%= employee.getEmployeeId()%></td>
					<td><%= employee.getFirstName() %></td>
					<td><%= employee.getLastName() %></td>
					<td><%= employee.getEmail() %></td>
					<td><%= employee.getJobTitle() %></td>
					<td><%= employee.getReportsTo() %></td>
					<td><%= employee.getSalary() %></td>
					<td>
					
						<a href="EmployeeControllerServlet?command=<%= commandValue%>&employeeID=<%=employeeIdValue%>">Update</a> 
						| <a href="EmployeeControllerServlet?command=<%= deleteCommandValue%>&employeeID=<%=employeeIdValue%>" onclick = "if(!(confirm('Are you sure you want to delete?'))) return false">Delete</a>
					
					</td>
				</tr>
				<%} %>
					
			
			
			</table>
			
		</div>
	</div>
	


</body>



</html>