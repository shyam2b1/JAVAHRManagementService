package com.scs.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.scs.employee.model.Employee;

public class EmployeeDAO {
	private DataSource datasource;
	
	public EmployeeDAO(DataSource datasource) {
		this.datasource = datasource;
	}
	
	public void addEmployee(Employee employee) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			myConn = datasource.getConnection();
			String sql = "insert into employee " + "(first_name, last_name, email, job_title, reports_to, salary)" + " values (?,?,?,?,?,?)";
			
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setString(1, employee.getFirstName());
			myStmt.setString(2, employee.getLastName());
			myStmt.setString(3, employee.getEmail());
			myStmt.setString(4, employee.getJobTitle());
			myStmt.setString(5, employee.getReportsTo());
			myStmt.setInt(6, employee.getSalary());
			
			myStmt.execute();
			
		}finally {
			//close JDBC objects
			closeConnection(myConn, myStmt, null);
		}
	}
	
	public void deleteEmployee(String employeeId) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
//		ResultSet myRes = null;
		int convertedemployeeID = Integer.parseInt(employeeId);
		
		try {
			//Open a connection
			myConn = datasource.getConnection();
			String sql = "delete from employee where employee_id = ?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, convertedemployeeID);
			myStmt.execute();
			
		} finally {
			//Close JDBC objects
			closeConnection(myConn, myStmt, null);
			
		}
		
	}
	
	public Employee getEmployee(String employeeId) throws Exception{
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRes = null;
		int theEmployeeId = Integer.parseInt(employeeId);
		Employee employee = null;
		try {
			myConn = datasource.getConnection();
			String sql = "select * from employee where " + "employee_id = ?";
			
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, theEmployeeId);
			myRes = myStmt.executeQuery();
//			System.out.println("myRes value: "+myRes);
			while(myRes.next()) {
				String firstName = myRes.getString("first_name");
				String lastName = myRes.getString("last_name");
				String email = myRes.getString("email");
				String jobTitle = myRes.getString("job_title");
				String reportsTo = myRes.getString("reports_to");
				int salary = myRes.getInt("salary");
				int theemployeeId = myRes.getInt("employee_id");
				employee = new Employee(firstName, lastName, email, jobTitle, reportsTo, salary,theemployeeId);
			}
			
		} finally {
			//close JDBC objects.
			closeConnection(myConn, myStmt, myRes);
			
		}
		
		return employee;
	}
	
	public List<Employee> listEmployee() throws Exception{
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRes = null;
		List<Employee> theEmployee = new ArrayList<>();
		
		try {
			// Get a DB connection
			myConn = datasource.getConnection();
			
			//Prepare SQL query
			String sql = "select * from employee";
			
			//Prepare SQL Statement
			myStmt = myConn.prepareStatement(sql);
			
			//Executing SQL query
			
			myRes = myStmt.executeQuery(sql);
			
			while(myRes.next()) {
				String firstName = myRes.getString("first_name");
				String lastName = myRes.getString("last_name");
				String email = myRes.getString("email");
				String jobTitle = myRes.getString("job_title");
				String reportsTo = myRes.getString("reports_to");
				int salary = myRes.getInt("salary");
				int employeeId = myRes.getInt("employee_id");
//				System.out.println("employeeID from DB:"+employeeId);
				
				Employee employeeList = new Employee(firstName,lastName,email,jobTitle,reportsTo,salary,employeeId);
				theEmployee.add(employeeList);
			}
		}finally {
			//close JDBC objects.
			closeConnection(myConn, myStmt, myRes);
		}
		return theEmployee;
	}

	private void closeConnection(Connection myConn, PreparedStatement myStmt, ResultSet myRes) throws Exception {
		try {
			if(myConn != null) {
				myConn.close();
			}
			if(myStmt != null) {
				myStmt.close();
			}
			if(myRes != null) {
				myRes.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void updateEmployee(Employee employee) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			myConn = datasource.getConnection();
			String sql = "update employee set first_name = ?, last_name = ?, email = ?, job_title = ?, reports_to = ?, salary = ? where employee_id = ?";
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setString(1, employee.getFirstName());
			myStmt.setString(2, employee.getLastName());
			myStmt.setString(3, employee.getEmail());
			myStmt.setString(4, employee.getJobTitle());
			myStmt.setString(5, employee.getReportsTo());
			myStmt.setInt(6, employee.getSalary());
			myStmt.setInt(7, employee.getEmployeeId());
			
			myStmt.execute();
		} finally {
			closeConnection(myConn, myStmt, null);
			
		}
		
	}

//	public List<Employee> searchEmployeeById(String employeeID) throws Exception {
//		Connection myConn = null;
//		PreparedStatement myStmt = null;
//		ResultSet myRes = null;
//		List<Employee> theEmployee = new ArrayList<>();
//		int theEmployeeId = Integer.parseInt(employeeID);
//		
//		try {
//			// Get a DB connection
//			myConn = datasource.getConnection();
//			
//			//Prepare SQL query
//			String sql = "select * from employee where employee_id = ?";
//			
//			//Prepare SQL Statement
//			myStmt = myConn.prepareStatement(sql);
//			
//			myStmt.setInt(1, theEmployeeId);
//			
//			
//			//Executing SQL query
//			
//			myRes = myStmt.executeQuery();
//			
//			while(myRes.next()) {
//				String firstName = myRes.getString("first_name");
//				String lastName = myRes.getString("last_name");
//				String email = myRes.getString("email");
//				String jobTitle = myRes.getString("job_title");
//				String reportsTo = myRes.getString("reports_to");
//				int salary = myRes.getInt("salary");
//				int employeeId = myRes.getInt("employee_id");
////				System.out.println("employeeID from DB:"+employeeId);
//				
//				Employee employeeList = new Employee(firstName,lastName,email,jobTitle,reportsTo,salary,employeeId);
//				theEmployee.add(employeeList);
//			}
//		}finally {
//			//close JDBC objects.
//			closeConnection(myConn, myStmt, myRes);
//		}
//		return theEmployee;
//		
//	}

	public List<Employee> searchEmployeeByLastName(String lastName) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRes = null;
		List<Employee> theEmployee = new ArrayList<>();
		
		try {
			// Get a DB connection
			myConn = datasource.getConnection();
			
			//Prepare SQL query
			String sql = "select * from employee where last_name = ?";
			
			//Prepare SQL Statement
			myStmt = myConn.prepareStatement(sql);
			System.out.println("lastName in Dao class: "+lastName);
			
			myStmt.setString(1, lastName);
			
			
			//Executing SQL query
			
			myRes = myStmt.executeQuery();
			
			while(myRes.next()) {
				String firstName = myRes.getString("first_name");
				String finallastName = myRes.getString("last_name");
				String email = myRes.getString("email");
				String jobTitle = myRes.getString("job_title");
				String reportsTo = myRes.getString("reports_to");
				int salary = myRes.getInt("salary");
				int employeeId = myRes.getInt("employee_id");
				System.out.println("finallastName in DAO:"+finallastName);
				
				Employee employeeList = new Employee(firstName,finallastName,email,jobTitle,reportsTo,salary,employeeId);
				theEmployee.add(employeeList);
			}
		}finally {
			//close JDBC objects.
			closeConnection(myConn, myStmt, myRes);
		}
		return theEmployee;
		
	}

	public void searchEmployeeByJobTitle(String jobTitle) {
		// TODO Auto-generated method stub
		
	}

	public void searchEmployeeByReportsTo(String reportTo) {
		// TODO Auto-generated method stub
		
	}

	public void searchEmployeeBySalary(String salary) {
		// TODO Auto-generated method stub
		
	}

}
