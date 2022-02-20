package com.scs.employee.model;

public class Employee {
	private String firstName;
	private String lastName;
	private String email;
	private String jobTitle;
	private String reportsTo;
	private int salary;
	private int employeeId;
	
	public Employee() {}
	
	
	
	public Employee(String firstName, String lastName, String email, String jobTitle, String reportsTo, int salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.jobTitle = jobTitle;
		this.reportsTo = reportsTo;
		this.salary = salary;
	}
	
	public Employee(String firstName, String lastName, String email, String jobTitle, String reportsTo, int salary, int employeeId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.jobTitle = jobTitle;
		this.reportsTo = reportsTo;
		this.salary = salary;
		this.employeeId = employeeId;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(String reportsTo) {
		this.reportsTo = reportsTo;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}



	public int getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	
	
	
}
