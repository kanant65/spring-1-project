package com.shoppingcart.app.service;

import java.util.List;
import java.util.Optional;

import com.shoppingcart.app.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public Optional<Employee> getEmployeeById(Long id);
	
	public Employee addEmployee(Employee employee);
	
	public void deleteEmployee(Long eid);
	
	public void updateEmployee(Employee employee, Long employeeId);
	
	public List<Employee> getEmployeeSortedByFirstName();
	
	public List<Employee> getEmployeeSortedByLastNameUsingNative();
	
	public List<Employee> getEmployeeByCode(String officeCode);
	
	public List<Employee> getEmployeesUsingPaging();
	
	public Iterable<Employee> getSortEmployeesUsingSorting();
}
