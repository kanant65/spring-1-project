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

import com.shoppingcart.app.exception.CustomerNotFoundException;
import com.shoppingcart.app.model.Customer;
import com.shoppingcart.app.service.CustomerService;

@RestController
@RequestMapping("/api/v1/")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	//get all Customer handler
	@GetMapping("customers")
	public ResponseEntity<List<Customer>> getAllCustomers() throws CustomerNotFoundException {
		List<Customer> customer = customerService.getAllCustomers();
		
		if(customer.size()<=0) {
			throw new CustomerNotFoundException("Customer record is empty");
		}
		return ResponseEntity.of(Optional.of(customer));
	}

	//get single Customer handler
	@GetMapping("customers/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id) throws CustomerNotFoundException  {
		Customer customer = customerService.getCustomerById(id)
				 .orElseThrow(() -> new CustomerNotFoundException("Customer not exist with id:" + id));
		
		if(customer == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(customer));
	}
	
	//new Customer handler
	@PostMapping("customers")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {
		Customer c = customerService.addCustomer(customer);
		
		if(c == null) {
			throw new CustomerNotFoundException("Customer not get inserted");
		}
			return ResponseEntity.of(Optional.of(c));
	}
	
	//delete Customer handler
	@DeleteMapping("customers/{customerId}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable("customerId") Long customerId) throws CustomerNotFoundException {
		
		customerService.getCustomerById(customerId)
			.orElseThrow(() -> new CustomerNotFoundException("Customer not exist with id:" + customerId));

		customerService.deleteCustomer(customerId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	//update Customer handler
	@PutMapping("customers/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable("customerId") Long customerId) throws CustomerNotFoundException {
		
		customerService.getCustomerById(customerId)
			.orElseThrow(() -> new CustomerNotFoundException("Customer not exist with id:" + customerId));
		
		customerService.updateCustomer(customer, customerId);
		
		return ResponseEntity.ok().body(customer);
		
	}

	//get all Customer handler sorted by name using query
	@GetMapping("customers/sort")
	public ResponseEntity<List<Customer>> getCustomerSortedByName() throws CustomerNotFoundException {
		List<Customer> customer = customerService.getCustomerSortedByName();
		
		if(customer.size()<=0) {
			throw new CustomerNotFoundException("Customer not exist");
		}
		return ResponseEntity.of(Optional.of(customer));
	}
	
	//get all Customer handler sorted by state using native query
	@GetMapping("customers/sort/native")
	public ResponseEntity<List<Customer>> getCustomerSortedByStateUsingNative() throws CustomerNotFoundException {
		List<Customer> customer = customerService.getCustomerSortedByStateUsingNative();
		
		if(customer.size()<=0) {
			throw new CustomerNotFoundException("Customer not exists ");
		}
		return ResponseEntity.of(Optional.of(customer));
	}

	//get  Customer handler by customerFirstName and customerLastName
	@GetMapping("customers/name/{customerFirstName}/{customerLastName}")
	public ResponseEntity<List<Customer>> getCustomerByFirstNameAndLastName(@PathVariable("customerFirstName") String customerFirstName, @PathVariable("customerLastName") String customerLastName ) throws CustomerNotFoundException{
		List<Customer> customer = customerService.getCustomerByFirstNameAndLastName(customerFirstName, customerLastName);
		
		if(customer == null) {
			throw new CustomerNotFoundException("Customer not exists with customerFirstName : " + customerFirstName + "and customerLastName" + customerLastName);
		}
		return ResponseEntity.of(Optional.of(customer));
	}

	//implementing paging
	@GetMapping("customers/paging")
	public ResponseEntity<List<Customer>> getCustomers() throws CustomerNotFoundException{
		List<Customer> customer = customerService.getCustomersUsingPaging();
		
		if(customer.size()<=0) {
			throw new CustomerNotFoundException("Customer not exist");
		}
		return ResponseEntity.of(Optional.of(customer));
	}

	//sorting implementation
	@GetMapping("customers/sorting")
	public ResponseEntity<Iterable<Customer>> getSortCustomers() throws CustomerNotFoundException {
		
		List<Customer> customer = (List<Customer>) customerService.getSortCustomersUsingSorting();
		
		if(customer.size()<=0) {
			throw new CustomerNotFoundException("Customer not exist");
		}
		return ResponseEntity.of(Optional.of(customer));
	}
	
}
