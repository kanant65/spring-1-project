package shopping.cart.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import shopping.cart.demo.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public Customer findBycustomerName(String customerName);
	
	public List<Customer> findAll();
	
	public void deleteById(Long customerNumber);
	
	@Query(value = "SELECT c FROM Customer c ORDER BY customer_name")
	public List<Customer> findAllSortedByName();
	
	@Query(value = "SELECT * FROM CUSTOMERs ORDER BY customer_name", nativeQuery = true)
	public List<Customer> findAllSortedByNameUsingNative();
	
}
