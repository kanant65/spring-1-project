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

import shopping.cart.demo.exception.CustomerNotFoundException;
import shopping.cart.demo.model.Customer;
import shopping.cart.demo.repository.CustomerRepository;

@RestController
@RequestMapping("/api/v1/")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	//get all Customer handler
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers() throws CustomerNotFoundException {
		List<Customer> list = customerRepository.findAll();
		
		if(list.size()<=0) {
			throw new CustomerNotFoundException("Customer not exist");
		}
		return ResponseEntity.of(Optional.of(list));
	}

	//get single Customer handler
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id) throws CustomerNotFoundException  {
		Customer customer = customerRepository.findById(id)
				 .orElseThrow(() -> new CustomerNotFoundException("Customer not exist with id:" + id));
		
		if(customer == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(customer));
	}
	
	//new Customer handler
	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {
		Customer c = customerRepository.save(customer);
		
		if(customerRepository.save(customer) == null) {
			throw new CustomerNotFoundException("Customer not get inserted");
		}
			return ResponseEntity.of(Optional.of(c));
	}
	
	//delete Customer handler
	@DeleteMapping("/customers/{customerId}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable("customerId") Long customerId) throws CustomerNotFoundException {
		
		Customer customer = customerRepository.findById(customerId)
				 .orElseThrow(() -> new CustomerNotFoundException("Customer not exist with id:" + customerId));
		
		customerRepository.delete(customer);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	//update Customer handler
	@PutMapping("/customers/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable("customerId") Long customerId) throws CustomerNotFoundException {
		
		Customer updateCustomer = customerRepository.findById(customerId)
				 .orElseThrow(() -> new CustomerNotFoundException("Customer not exist with id:" + customerId));
		
		updateCustomer.setCustomerNumber(customerId);
		customerRepository.save(customer);
		
		return ResponseEntity.ok(updateCustomer);
		
	}

	//get all Customer handler sorted by name
	@GetMapping("/customers/sort")
	public ResponseEntity<List<Customer>> getCustomerSortedByName() throws CustomerNotFoundException {
		List<Customer> list = customerRepository.findAllSortedByName();
		
		if(list.size()<=0) {
			throw new CustomerNotFoundException("Customer not exist");
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	//get all Customer handler sorted by name using native
	@GetMapping("customers/sort/native")
	public ResponseEntity<List<Customer>> getCustomerSortedByNameUsingNative() throws CustomerNotFoundException {
		List<Customer> list = customerRepository.findAllSortedByNameUsingNative();
		
		if(list.size()<=0) {
			throw new CustomerNotFoundException("Customer not exists ");
		}
		return ResponseEntity.of(Optional.of(list));
	}
	

	//get single Customer handler by customerName
	@GetMapping("customers/customerName")
	public ResponseEntity<Customer> getCustomerByName(@RequestParam String customerName) throws CustomerNotFoundException{
		Customer customer = customerRepository.findBycustomerName(customerName);
		
		if(customer == null) {
			throw new CustomerNotFoundException("Customer not exists with customerName : " + customerName);
		}
		return ResponseEntity.of(Optional.of(customer));
	}
}
