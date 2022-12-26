package com.shoppingcart.app.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shoppingcart.app.model.Customer;
import com.shoppingcart.app.repository.CustomerRepository;
import com.shoppingcart.app.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	//get all Customers
	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> list = customerRepository.findAll();
		return list;
	}

	//get single Customer by id
	@Override
	public Optional<Customer> getCustomerById(Long id) {
		Optional<Customer> customer = customerRepository.findById(id);
		return customer;
	}

	//adding the Customer
	@Override
	public Customer addCustomer(Customer customer) {
		Customer result = customerRepository.save(customer);
		return result;
	}

	//delete the Customer
	@Override
	public void deleteCustomer(Long cid) {
		customerRepository.deleteById(cid);
		
	}

	//update the Customer
	@Override
	public void updateCustomer(Customer customer, Long customerId) {
		customer.setCustomerNumber(customerId);
		customerRepository.save(customer);
		
	}

	//get all Customers sorted by name using query
	@Override
	public List<Customer> getCustomerSortedByName() {
		List<Customer> list = customerRepository.findAllSortedByName();
		return list;
	}

	//get all Customers sorted by state using native query 
	@Override
	public List<Customer> getCustomerSortedByStateUsingNative() {
		List<Customer> list = customerRepository.findAllSortedByStateUsingNative();
		return list;
	}

	//get all Customers by the matched first name and last name
	@Override
	public List<Customer> getCustomerByFirstNameAndLastName(String customerFirstName, String customerLastName) {
		List<Customer> list = customerRepository.findByFirstNameAndLastName(customerFirstName, customerLastName);
		return list;
	}

	//get all Customers by using paging concept
	@Override
	public List<Customer> getCustomersUsingPaging() {
		Pageable pageable = PageRequest.of(0, 2);
		List<Customer> list = customerRepository.findCustomers(pageable);
		return list;
	}

	//get all Customers in a sort order of state using the concept Sorting
	@Override
	public Iterable<Customer> getSortCustomersUsingSorting() {
		String sortBy = "state";
		List<Customer> list = (List<Customer>) customerRepository.sortCustomer(Sort.by(Sort.Direction.DESC,sortBy));
		return list;
	}

}
