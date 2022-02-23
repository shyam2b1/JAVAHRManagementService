package com.scs.employee.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.scs.employee.dao.EmployeeDAO;
import com.scs.employee.model.Employee;
import com.scs.employee.util.DBUtil;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeControllerServlet")
public class EmployeeControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmployeeDAO employeeDao; 
	
	@Resource (name="jdbc/web-employee-tracker")
    private DataSource datasource;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			employeeDao = new EmployeeDAO(datasource);
		} catch(Exception exec){
			System.out.println("Exception is:"+exec); 
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String params = request.getParameter("command");
		try {
			if(params == null) {
				
				listEmployee(request, response);
				
			}
			switch(params) {
			
			case "ADD":
				addNewEmployee(request, response);
				break;
			case "DELETE":
				deleteEmployee(request, response);
				break;
			case "LOAD":
				loadEmployee(request, response);
				break;
			case "UPDATE":
				updateEmployee(request, response);
				break;
			case "SEARCH":
				searchEmployee(request, response);
				break;
			default:
				listEmployee(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}

	private void searchEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
		
		if(request.getParameter("EmployeeID") != null && !request.getParameter("EmployeeID").isEmpty()) {
			String employeeID = request.getParameter("EmployeeID");
			Employee employee = employeeDao.getEmployee(employeeID);
			List<Employee> employeesList = new ArrayList<>();
			
			if(!(employee == null)) {
				
				employeesList.add(employee);
				System.out.println("employeesList is "+employeesList);
				request.setAttribute("EMPLOYEE_LIST", employeesList);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/list-searched-employee.jsp");
				dispatcher.forward(request, response);
			}else {
				request.setAttribute("EMPLOYEE_LIST", null);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/list-searched-employee.jsp");
				dispatcher.forward(request, response);
			}			
		}
		
		if(request.getParameter("lastName") != null && !request.getParameter("lastName").isEmpty()) {
			String thelastName = request.getParameter("lastName");
			List<Employee> employeesListbyName = employeeDao.searchEmployeeByLastName(thelastName);
			
			if(!(employeesListbyName.isEmpty())) {
				request.setAttribute("EMPLOYEE_LIST", employeesListbyName);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/list-searched-employee.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("EMPLOYEE_LIST", null);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/list-searched-employee.jsp");
				dispatcher.forward(request, response);
			}
		}
		
		if(request.getParameter("jobTitle") != null && !request.getParameter("jobTitle").isEmpty()) {
			String jobTitle = request.getParameter("jobTitle");
			employeeDao.searchEmployeeByJobTitle(jobTitle);
			List<Employee> employeesListbyJobTitle = employeeDao.searchEmployeeByJobTitle(jobTitle);
			
			if(!(employeesListbyJobTitle.isEmpty())) {
				request.setAttribute("EMPLOYEE_LIST", employeesListbyJobTitle);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/list-searched-employee.jsp");
				dispatcher.forward(request, response);
			}else {
				request.setAttribute("EMPLOYEE_LIST", null);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/list-searched-employee.jsp");
				dispatcher.forward(request, response);
			}
		}
		
		if(request.getParameter("from") != null && !request.getParameter("from").isEmpty() && request.getParameter("to") != null && !request.getParameter("to").isEmpty()) {
			String fromSalary = request.getParameter("from");
			String toSalary = request.getParameter("to");
			
			List<Employee> employeesListbySalary = employeeDao.searchEmployeeBySalary(fromSalary, toSalary);
			if(!(employeesListbySalary.isEmpty())) {
				request.setAttribute("EMPLOYEE_LIST", employeesListbySalary);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/list-searched-employee.jsp");
				dispatcher.forward(request, response);
			}else {
				request.setAttribute("EMPLOYEE_LIST", null);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/list-searched-employee.jsp");
				dispatcher.forward(request, response);
			}
		}
//		if(request.getParameter("salary") != null && !request.getParameter("salary").isEmpty()) {
//			String salary = request.getParameter("salary");
//			employeeDao.searchEmployeeBySalary(salary);
//		}		
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int getEmployeeIdValue = Integer.parseInt(request.getParameter("employeeIdValue"));
		String getFirstName = request.getParameter("firstName");
		String getLastName = request.getParameter("lastName");
		String getEmail = request.getParameter("email");
		String getJobTitle = request.getParameter("jobTitle");
		String getReportsTo = request.getParameter("report");
		int getSalary = Integer.parseInt(request.getParameter("salary"));
		Employee employee = new Employee(getFirstName, getLastName, getEmail, getJobTitle, getReportsTo, getSalary, getEmployeeIdValue); 
		employeeDao.updateEmployee(employee);
		listEmployee(request, response);
	}

	private void loadEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String theemployeeIdValue = request.getParameter("employeeID");
		Employee theEmployee = employeeDao.getEmployee(theemployeeIdValue);
		request.setAttribute("THE_EMPLOYEE_LIST", theEmployee);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-employee-page.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String theemployeeIdValue = request.getParameter("employeeID");
//		System.out.println("test is: "+test);
//		int theemployeeIdValue = Integer.parseInt(request.getParameter("employeeIdValue"));
		employeeDao.deleteEmployee(theemployeeIdValue);
		
		// Go back to List
		listEmployee(request, response);
		
		
	}

	private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Employee> employeesList = employeeDao.listEmployee();
//		System.out.println("employeesList : "+employeesList.toString());		
		request.setAttribute("EMPLOYEE_LIST", employeesList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-employee-details.jsp");
		dispatcher.forward(request, response);
	
	}

	private void addNewEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String jobTitle = request.getParameter("jobTitle");
		String reportsTo = request.getParameter("report");
//		System.out.println("salary is: "+request.getParameter("salary"));
//		String test = request.getParameter("salary");
//		System.out.println("salary test is: "+test);
		int Salary = Integer.parseInt(request.getParameter("salary"));
		
		Employee employee = new Employee(firstName, lastName, email, jobTitle, reportsTo, Salary);
		employeeDao.addEmployee(employee);
		
		// send request back to List page
		listEmployee(request, response);
		
	}

}
