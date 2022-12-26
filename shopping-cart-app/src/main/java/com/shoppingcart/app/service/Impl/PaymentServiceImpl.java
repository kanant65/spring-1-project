package com.shoppingcart.app.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shoppingcart.app.model.Payment;
import com.shoppingcart.app.repository.PaymentRepository;
import com.shoppingcart.app.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	//get all Payments
	public List<Payment> getAllPayments(){
		List<Payment> list = paymentRepository.findAll();
		return list;
	}
		
	//get single Payment by id
	public Optional<Payment> getPaymentById(Long id) {
		Optional<Payment> payment = paymentRepository.findById(id);
		return payment;
	}
		
	//adding the Payment
	public Payment addPayment(Payment payment) {
		Payment result = paymentRepository.save(payment);
		return result;
	}
		
	//delete the Payment
	public void deletePayment(Long pid) {
		paymentRepository.deleteById(pid);
	}
		
	//update the Payment
	public void updatePayment(Payment payment, Long paymentId) {
		payment.setCheckNumber(paymentId);
		paymentRepository.save(payment);
	}

	//get all Payments in a sort order of amount using query
	@Override
	public List<Payment> getPaymentDetailSortedByAmount() {
		List<Payment> list = paymentRepository.findAllSortedByAmount();
		return list;
	}

	//get all Payments in a sort order of amount using native query
	@Override
	public List<Payment> getPaymentSortedByAmountUsingNative() {
		List<Payment> list = paymentRepository.findAllSortedByAmountUsingNative();
		return list;
	}

	//get all Payments by the matched amount
	@Override
	public List<Payment> getPaymentByAmount(double amount) {
		List<Payment> list = paymentRepository.findByAmount(amount);
		return list;
	}

	//get all Payments by using paging concept
	@Override
	public List<Payment> getPaymentsUsingPaging() {
		Pageable pageable = PageRequest.of(0, 2);
		List<Payment> list = paymentRepository.findPayments(pageable);
		return list;
	}

	//get all Payments in a sort order of paymentDate using the concept Sorting
	@Override
	public Iterable<Payment> getSortPaymentsUsingSorting() {
		String sortBy = "paymentDate";
		List<Payment> list = (List<Payment>) paymentRepository.sortPayment(Sort.by(Sort.Direction.DESC,sortBy));
		return list;
	}

}
