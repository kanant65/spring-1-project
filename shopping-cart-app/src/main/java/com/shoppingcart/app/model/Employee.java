package com.shoppingcart.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@Column(name = "employee_Number")
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long employeeNumber;
	
	@Column(name = "last_name", nullable = false, length = 255)
	private String lastName;
	
	@Column(name = "first_name", nullable = false, length = 255)
	private String firstName;
	
	@Column(name = "Extension", nullable = false, length = 255)
	private String extension;
	
	@Column(name = "Email", nullable = false, length = 255)
	private String email;
	
	@Column(name = "Office_code", nullable = false, length = 255)
	private String officeCode;
	
	@Column(name = "Reports_to", nullable = false, length = 255)
	private String reportsTo;
	
	@Column(name = "Job_title", nullable = false, length = 255)
	private String jobTitle;
	
	@OneToMany
	@JoinColumn(name="employee_employeenumber")
	private List<Customer> customers;
	
	@OneToMany
	@JoinColumn(name = "Modified_empTable")
	private List<Employee> employees;
	
	@ManyToOne
	@JoinColumn(name="office_officecode")
	private Office offices;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(long employeeNumber, String lastName, String firstName, String extension, String email,
			String officeCode, String reportsTo, String jobTitle, List<Customer> customers, List<Employee> employees,
			Office offices) {
		super();
		this.employeeNumber = employeeNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.extension = extension;
		this.email = email;
		this.officeCode = officeCode;
		this.reportsTo = reportsTo;
		this.jobTitle = jobTitle;
		this.customers = customers;
		this.employees = employees;
		this.offices = offices;
	}

	public Employee(String lastName, String firstName, String extension, String email, String officeCode,
			String reportsTo, String jobTitle, List<Customer> customers, List<Employee> employees, Office offices) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.extension = extension;
		this.email = email;
		this.officeCode = officeCode;
		this.reportsTo = reportsTo;
		this.jobTitle = jobTitle;
		this.customers = customers;
		this.employees = employees;
		this.offices = offices;
	}

	public long getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(long employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	public String getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(String reportsTo) {
		this.reportsTo = reportsTo;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Office getOffices() {
		return offices;
	}

	public void setOffices(Office offices) {
		this.offices = offices;
	}

	@Override
	public String toString() {
		return "Employee [employeeNumber=" + employeeNumber + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", extension=" + extension + ", email=" + email + ", officeCode=" + officeCode + ", reportsTo="
				+ reportsTo + ", jobTitle=" + jobTitle + ", customers=" + customers + ", employees=" + employees
				+ ", offices=" + offices + "]";
	}

}

