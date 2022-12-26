package shopping.cart.demo.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import shopping.cart.demo.controller.CustomerController;
import shopping.cart.demo.exception.CustomerNotFoundException;
import shopping.cart.demo.model.Customer;

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
		
		Customer c1 = new Customer("Nikita Singh", "Singh", "Nikita", "79797979708",
				"Kalinagar Namkum", "Kalinagar Namkum", "Ranchi", "Jharkhand", "834010",
				"India", null, 50L, null, null);
		
		Customer c2 = new Customer("Abhishek Singh", "Singh", "Abhishek", "6268658708",
				"Khijri Namkum", "Khijri Namkum", "Ranchi", "Jharkhand", "834010",
				"India", null, 10L, null, null);
		
		Customer c3 = new Customer("Sushmita Kumari", "Kumari", "Sushmita", "6578957708",
				"Olympia, WashingTon", "Olympia, WashingTon", "Olympia", "WashingTon", "342610",
				"America", null, 20L, null, null);
		
		Customer c4 = new Customer("Nick Jonas", "Jonas", "Nick", "5797957708",
				"LA, California", "LA, California", "California", "WashingTon", "342010",
				"America", null, 35L, null, null);
		
		Customer c5 = new Customer("Salman Khan", "Khan", "Salman", "9999999908",
				"Bandra, Mumbai", "Bandra, Mumbai", "Bandra", "Mumbai", "423810",
				"India", null, 40L, null, null);
	
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		customers.add(c4);
		customers.add(c5);
		
		return customers;
	}
}
