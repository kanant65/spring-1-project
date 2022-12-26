package com.shoppingcart.app.service;

import java.util.List;
import java.util.Optional;

import com.shoppingcart.app.model.Customer;

public interface CustomerService {

	public List<Customer> getAllCustomers();
	
	public Optional<Customer> getCustomerById(Long id);
	
	public Customer addCustomer(Customer customer);
	
	public void deleteCustomer(Long cid);
	
	public void updateCustomer(Customer customer, Long customerId);
	
	public List<Customer> getCustomerSortedByName();
	
	public List<Customer> getCustomerSortedByStateUsingNative();
	
	public List<Customer> getCustomerByFirstNameAndLastName( String customerFirstName, String customerLastName );
	
	public List<Customer> getCustomersUsingPaging();
	
	public Iterable<Customer> getSortCustomersUsingSorting();
	
}
