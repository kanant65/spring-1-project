package shopping.cart.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import shopping.cart.demo.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	public List<Payment> findAll();
	
	public void deleteById(Long customerNumber);

	@Query(value = "SELECT p FROM Payment p ORDER BY amount")
	public List<Payment> findAllSortedByAmount();
	
	@Query(value = "SELECT * FROM PAYMENTS ORDER BY amount", nativeQuery = true)
	public List<Payment> findAllSortedByAmountUsingNative();
}

