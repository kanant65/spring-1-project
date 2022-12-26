package com.shoppingcart.app.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shoppingcart.app.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query(value = "SELECT c FROM Customer c WHERE contactFirstName = ?1 AND contactLastName = ?2")
	public List<Customer> findByFirstNameAndLastName(String contactFirstName, String contactLastName);

	@Query(value = "SELECT c FROM Customer c ORDER BY customerName")
	public List<Customer> findAllSortedByName();
	
	@Query(value = "SELECT * FROM CUSTOMERS ORDER BY state", nativeQuery = true)
	public List<Customer> findAllSortedByStateUsingNative();
	
	@Query(value = "SELECT c FROM Customer c")
	public List<Customer> findCustomers(Pageable pageable);
	
	@Query("from Customer" )
	public Iterable<Customer> sortCustomer(Sort sort);
	
}
