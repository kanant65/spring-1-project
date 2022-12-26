package com.shoppingcart.app.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shoppingcart.app.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	public List<Payment> findByAmount(double amount);

	@Query(value = "SELECT p FROM Payment p ORDER BY amount")
	public List<Payment> findAllSortedByAmount();
	
	@Query(value = "SELECT * FROM PAYMENTS ORDER BY amount", nativeQuery = true)
	public List<Payment> findAllSortedByAmountUsingNative();
	
	@Query("From Payment")
	public List<Payment> findPayments(Pageable pageable);
	
	@Query("from Payment" )
	public Iterable<Payment> sortPayment(Sort sort);
}

