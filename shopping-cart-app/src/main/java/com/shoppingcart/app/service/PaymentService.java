package com.shoppingcart.app.service;

import java.util.List;
import java.util.Optional;

import com.shoppingcart.app.model.Payment;

public interface PaymentService {

	public List<Payment> getAllPayments();
	
	public Optional<Payment> getPaymentById(Long id);
	
	public Payment addPayment(Payment payment);
	
	public void deletePayment(Long pid);
	
	public void updatePayment(Payment payment, Long paymentId);
	
	public List<Payment> getPaymentDetailSortedByAmount();
	
	public List<Payment> getPaymentSortedByAmountUsingNative();
	
	public List<Payment> getPaymentByAmount(double amount);
	
	public List<Payment> getPaymentsUsingPaging();
	
	public Iterable<Payment> getSortPaymentsUsingSorting();
}
