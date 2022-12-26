package shopping.cart.demo.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shopping.cart.demo.exception.EmployeeNotFoundException;
import shopping.cart.demo.model.Employee;
import shopping.cart.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	//get all Employee handler
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() throws EmployeeNotFoundException {
		List<Employee> list = employeeRepository.findAll();
		
		if(list.size()<=0) {
			throw new EmployeeNotFoundException("Employee record is empty");
		}
		//return ResponseEntity.of(Optional.of(list));
		return new ResponseEntity<List<Employee>>(employeeRepository.findAll(), HttpStatus.OK);
	}

	//get single Employee handler by id
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) throws EmployeeNotFoundException  {
		Employee employee = employeeRepository.findById(id)
				 .orElseThrow(() -> new EmployeeNotFoundException("Employee not exist with id:" + id));
		
		if(employee == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(employee));
	}
	
	//add new Employee handler
	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) throws EmployeeNotFoundException {
		Employee emp = employeeRepository.save(employee);
		
		if(employeeRepository.save(employee) == null) {
			throw new EmployeeNotFoundException("Employee is not inserted");
		}
		return ResponseEntity.of(Optional.of(emp));
	}
	
	//delete Employee handler
	@DeleteMapping("/employees/{employeeId}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("employeeId") Long employeeId) throws EmployeeNotFoundException {
		
		Employee employee = employeeRepository.findById(employeeId)
				 .orElseThrow(() -> new EmployeeNotFoundException("Employee not exist with id:" + employeeId));
		
		employeeRepository.delete(employee);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	//update Employee handler
	@PutMapping("/employees/{employeeId}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("employeeId") Long employeeId) throws EmployeeNotFoundException {
		
		Employee updateEmployee = employeeRepository.findById(employeeId)
				 .orElseThrow(() -> new EmployeeNotFoundException("Employee not exist with id:" + employeeId));
		
		updateEmployee.setEmployeeNumber(employeeId);
		employeeRepository.save(employee);
		
		return ResponseEntity.ok(updateEmployee);
		
	}

	//get all Employees handler sorted by name
	@GetMapping("employees/sort")
	public ResponseEntity<List<Employee>> getEmployeeSortedByName() throws EmployeeNotFoundException {
		List<Employee> list = employeeRepository.findAllSortedByName();
		
		if(list.size()<=0) {
			throw new EmployeeNotFoundException("Employee not exists ");
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	//get all Employees handler sorted by name using native
	@GetMapping("employees/sort/native")
	public ResponseEntity<List<Employee>> getEmployeeSortedByNameUsingNative() throws EmployeeNotFoundException {
		List<Employee> list = employeeRepository.findAllSortedByNameUsingNative();
		
		if(list.size()<=0) {
			throw new EmployeeNotFoundException("Employee not exists ");
		}
		return ResponseEntity.of(Optional.of(list));
	}	
	
	//get single Employee handler by name
	@GetMapping("employees/email")
	public ResponseEntity<Employee> getEmployeeByEmail(@RequestParam String email) throws EmployeeNotFoundException{
		Employee employee = employeeRepository.findByEmail(email);
		
		if(employee == null) {
			throw new EmployeeNotFoundException("Employee not exists : " + employee);
		}
		return ResponseEntity.of(Optional.of(employee));
	}
	
	//get Employee handler by name
	@GetMapping("employees/{firstName}")
	public ResponseEntity<List<Employee>> getEmployeeByName(@RequestParam String firstName) throws EmployeeNotFoundException{
		List<Employee> employee = employeeRepository.findByFirstName(firstName);
		
		if(employee == null) {
			throw new EmployeeNotFoundException("Employee not exists with name : " + employee);
		}
		//return ResponseEntity.of(Optional.of(employee));
		return new ResponseEntity<List<Employee>>(employeeRepository.findByFirstName(firstName), HttpStatus.OK);
	}
	
	//get single Employee handler by office code
	@GetMapping("employees/officeCode")
	public ResponseEntity<Employee> getEmployeeByCode(@RequestParam String officeCode) throws EmployeeNotFoundException{
		Employee employee = employeeRepository.findByofficeCode(officeCode);
		
		if(employee == null) {
			throw new EmployeeNotFoundException("Employee not exists with OfficeCode : " + officeCode);
		}
		return ResponseEntity.of(Optional.of(employee));
	}
}
