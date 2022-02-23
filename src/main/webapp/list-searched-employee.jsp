<%@ page import = "java.util.*, com.scs.employee.model.*" %>

<html>
<% List <Employee> theEmployeeList = (List<Employee>)request.getAttribute("EMPLOYEE_LIST");

%>

<body>
<head>
	<link rel = "stylesheet" href = "css/style.css">

</head>
	<div id = "wrapper">
		<div id = "header">
			<h2><a href = "EmployeeControllerServlet">HR Reporting Service</a></h2>
		</div>
	
	</div>
	
	<div id = "container">
		<div id = "content">
		
		<%
		if(theEmployeeList == null){ 
		%>
			<h3>Employee Not Found</h3>	
			
		<% } else {%>
			
			
			
		
			
			<table>
				<tr>
					<th>Employee Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Job Title</th>
					<th>Reports To</th>
					<th>Salary</th>
				</tr>
				
				<% for(Employee employee: theEmployeeList){
					%>
				
				<tr>
					<td><%= employee.getEmployeeId()%></td>
					<td><%= employee.getFirstName() %></td>
					<td><%= employee.getLastName() %></td>
					<td><%= employee.getEmail() %></td>
					<td><%= employee.getJobTitle() %></td>
					<td><%= employee.getReportsTo() %></td>
					<td><%= employee.getSalary() %></td>
				</tr>
				<%} 
				
				}%>
					
			
			
			</table><br>
			
			<a href = "search-employee-page.jsp">Back to Search Employee Page</a>
			
		</div>
	</div>
	


</body>



</html>