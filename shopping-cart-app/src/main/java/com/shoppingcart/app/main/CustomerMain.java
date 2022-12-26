package com.shoppingcart.app.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.shoppingcart.app.controller.CustomerController;
import com.shoppingcart.app.exception.CustomerNotFoundException;
import com.shoppingcart.app.model.Customer;

@Controller
public class CustomerMain {

	@Autowired
	private CustomerController customerController;
	
	public void customerRun() {
		System.out.println("\n Customer Entity records :");
		addCustomers(createCustomers());
	}

	//method to add Customers
	private void addCustomers(List<Customer> customers) {
		for(Customer customer : customers) {
			try {
				customerController.addCustomer(customer);
			} 
			catch (CustomerNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//method to create List Of Customers
	private List<Customer> createCustomers(){
		List<Customer> customers = new ArrayList<Customer>();
		
		Customer c1 = new Customer("Anant Kumar", "Kumar", "Anant", "10000000001",
				"Khijri, Namkum", "Khijri, Namkum", "Ranchi", "Jharkhand", "834010",
				"India", null, 50L, null, null);
		
		Customer c2 = new Customer("Nikita Singh", "Singh", "Nikita", "1000000002",
				"Kalinagar, Namkum", "Kalinagar, Namkum", "Ranchi", "Jharkhand", "834010",
				"India", null, 10L, null, null);
		
		Customer c3 = new Customer("Anant Kumar", "Kumar", "Anant", "10000000003",
				"Tatisilway, Ranchi", "Tatisilway, Ranchi", "Tatisilway", "Ranchi", "834009",
				"India", null, 20L, null, null);
		
		Customer c4 = new Customer("Aryan Raj", "Raj", "Aryan", "10000000004",
				"Hinoo, Ranchi", "Hinoo, Ranchi", "Hinoo", "Ranchi", "834003",
				"India", null, 35L, null, null);
		
		Customer c5 = new Customer("Babu Kumar", "Kumar", "Babu", "10000000005",
				"Birsa Chowk, Ranchi", "Birsa Chowk, Ranchi", "Birsa Chowk", "Ranchi", "834003",
				"India", null, 40L, null, null);
	
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		customers.add(c4);
		customers.add(c5);
		
		return customers;
	}
}
