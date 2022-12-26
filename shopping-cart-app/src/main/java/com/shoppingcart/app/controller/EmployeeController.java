package com.shoppingcart.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.app.exception.EmployeeNotFoundException;
import com.shoppingcart.app.model.Employee;
import com.shoppingcart.app.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	//get all Employee handler
	@GetMapping("employees")
	public ResponseEntity<List<Employee>> getAllEmployees() throws EmployeeNotFoundException {
		List<Employee> employee = employeeService.getAllEmployees();
		
		if(employee.size()<=0) {
			throw new EmployeeNotFoundException("Employee record is empty");
		}
		return ResponseEntity.of(Optional.of(employee));
	}

	//get single Employee handler by id
	@GetMapping("employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) throws EmployeeNotFoundException  {
		Employee employee = employeeService.getEmployeeById(id)
				 .orElseThrow(() -> new EmployeeNotFoundException("Employee not exist with id:" + id));
		
		if(employee == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(employee));
	}
	
	//add new Employee handler
	@PostMapping("employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) throws EmployeeNotFoundException {
		Employee emp = employeeService.addEmployee(employee);
		
		if(emp == null) {
			throw new EmployeeNotFoundException("Employee is not inserted");
		}
		return ResponseEntity.of(Optional.of(emp));
	}
	
	//delete Employee handler
	@DeleteMapping("employees/{employeeId}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("employeeId") Long employeeId) throws EmployeeNotFoundException {
		
		employeeService.getEmployeeById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not exist with id:" + employeeId));
		
		employeeService.deleteEmployee(employeeId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	//update Employee handler
	@PutMapping("employees/{employeeId}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("employeeId") Long employeeId) throws EmployeeNotFoundException {
		
		employeeService.getEmployeeById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not exist with id:" + employeeId));
		
		employeeService.updateEmployee(employee, employeeId);
		
		return ResponseEntity.ok(employee);
		
	}

	//get all Employees handler sorted by first name using query
	@GetMapping("employees/sort")
	public ResponseEntity<List<Employee>> getEmployeeSortedByFirstName() throws EmployeeNotFoundException {
		List<Employee> employee = employeeService.getEmployeeSortedByFirstName();
		
		if(employee.size()<=0) {
			throw new EmployeeNotFoundException("Employee not exists ");
		}
		return ResponseEntity.of(Optional.of(employee));
	}
	
	//get all Employees handler sorted by last name using native query
	@GetMapping("employees/sort/native")
	public ResponseEntity<List<Employee>> getEmployeeSortedByLastNameUsingNative() throws EmployeeNotFoundException {
		List<Employee> employee = employeeService.getEmployeeSortedByLastNameUsingNative();
		
		if(employee.size()<=0) {
			throw new EmployeeNotFoundException("Employee not exists ");
		}
		return ResponseEntity.of(Optional.of(employee));
	}	
	
	//get Employee handler by office code
	@GetMapping("employees/code/{officeCode}")
	public ResponseEntity<List<Employee>> getEmployeeByCode(@PathVariable("officeCode") String officeCode) throws EmployeeNotFoundException{
		List<Employee> employee = employeeService.getEmployeeByCode(officeCode);
		
		if(employee == null) {
			throw new EmployeeNotFoundException("Employee not exists with OfficeCode : " + officeCode);
		}
		return ResponseEntity.of(Optional.of(employee));
	}

	//implementing paging
	@GetMapping("employees/paging")
	public ResponseEntity<List<Employee>> getEmployees() throws EmployeeNotFoundException {
		List<Employee> employee = employeeService.getEmployeesUsingPaging();
		
		if(employee.size()<=0) {
			throw new EmployeeNotFoundException("Employee not exist");
		}
		return ResponseEntity.of(Optional.of(employee));
	}

	//sorting implementation
	@GetMapping("employees/sorting")
	public ResponseEntity<Iterable<Employee>> getSortEmployees() throws EmployeeNotFoundException {
		List<Employee> employee = (List<Employee>) employeeService.getSortEmployeesUsingSorting();
		
		if(employee.size()<=0) {
			throw new EmployeeNotFoundException("Employee not exist");
		}
		return ResponseEntity.of(Optional.of(employee));
	}
	
}
