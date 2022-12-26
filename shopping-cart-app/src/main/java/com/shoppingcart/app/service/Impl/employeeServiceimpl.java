package com.shoppingcart.app.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shoppingcart.app.model.Employee;
import com.shoppingcart.app.repository.EmployeeRepository;
import com.shoppingcart.app.service.EmployeeService;

@Service
public class employeeServiceimpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	//get all Employees
	public List<Employee> getAllEmployees(){
		List<Employee> list = employeeRepository.findAll();
		return list;
	}
			
	//get single Employee by id
	public Optional<Employee> getEmployeeById(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		return employee;
	}
			
	//adding the Employee
	public Employee addEmployee(Employee employee) {
		Employee result = employeeRepository.save(employee);
		return result;
	}
			
	//delete the Employee
	public void deleteEmployee(Long eid) {
		employeeRepository.deleteById(eid);
	}
			
	//update the Employee
	public void updateEmployee(Employee employee, Long employeeId) {
		employee.setEmployeeNumber(employeeId);
		employeeRepository.save(employee);
	}

	//get all Employees sorted by first name using query
	@Override
	public List<Employee> getEmployeeSortedByFirstName() {
		List<Employee> list = employeeRepository.findAllSortedByFirstName();
		return list;
	}

	//get all Employees sorted by last name using native query
	@Override
	public List<Employee> getEmployeeSortedByLastNameUsingNative() {
		List<Employee> list = employeeRepository.findAllSortedByLastNameUsingNative();
		return list;
	}

	//get all Employees by officeCode
	@Override
	public List<Employee> getEmployeeByCode(String officeCode) {
		List<Employee> list = employeeRepository.findByofficeCode(officeCode);
		return list;
	}

	//get all Employees by using paging concept
	@Override
	public List<Employee> getEmployeesUsingPaging() {
		Pageable pageable = PageRequest.of(0, 2);
		List<Employee> list = employeeRepository.findEmployees(pageable);
		return list;
	}

	//get all Employees sorted by reportsTo using Sorting
	@Override
	public Iterable<Employee> getSortEmployeesUsingSorting() {
		String sortBy = "reportsTo";
		List<Employee> list = (List<Employee>) employeeRepository.sortEmployee(Sort.by(Sort.Direction.ASC,sortBy));
		return list;
	}

}
