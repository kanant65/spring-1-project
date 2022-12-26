package com.shoppingcart.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.app.exception.PaymentNotFoundException;
import com.shoppingcart.app.model.Payment;
import com.shoppingcart.app.service.PaymentService;

@RestController
@RequestMapping("/api/v1/")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	//get all Payment handler
	@GetMapping("payments")
	public ResponseEntity<List<Payment>> getAllPayments() throws PaymentNotFoundException {
		List<Payment> payment = paymentService.getAllPayments();
		
		if(payment.size()<=0) {
			throw new PaymentNotFoundException("Payment not exist");
		}
		return ResponseEntity.of(Optional.of(payment));
	}

	//get single Payment handler
	@GetMapping("payments/{id}")
	public ResponseEntity<Payment> getPayment(@PathVariable("id") Long id) throws PaymentNotFoundException  {
		Payment payment = paymentService.getPaymentById(id)
				 .orElseThrow(() -> new PaymentNotFoundException("Payment not exist with id:" + id));
		
		if(payment == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(payment));
	}
	
	//new Payment handler
	@PostMapping("payments")
	public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) throws PaymentNotFoundException {
		Payment p = paymentService.addPayment(payment);
		
		if(p == null) {
			throw new PaymentNotFoundException("Payment not get inserted");
		}
		return ResponseEntity.of(Optional.of(p));
	}
	
	//delete Payment handler
	@DeleteMapping("payments/{paymentId}")
	public ResponseEntity<Void> deletePayment(@PathVariable("paymentId") Long paymentId) throws PaymentNotFoundException {
		
		paymentService.getPaymentById(paymentId)
			 .orElseThrow(() -> new PaymentNotFoundException("Payment not exist with id:" + paymentId));
		
		paymentService.deletePayment(paymentId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
	}
	
	//update Payment handler
	@PutMapping("payments/{paymentId}")
	public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment, @PathVariable("employeeId") Long paymentId) throws PaymentNotFoundException {
		
		paymentService.getPaymentById(paymentId)
			.orElseThrow(() -> new PaymentNotFoundException("Payment not exist with id:" + paymentId));
		
		paymentService.updatePayment(payment, paymentId);
		
		return ResponseEntity.ok().body(payment);
	}

	//get all Payment handler sorted by amount
	@GetMapping("payments/sort")
	public ResponseEntity<List<Payment>> getPaymentDetailSortedByAmount() throws PaymentNotFoundException {
		List<Payment> payment = paymentService.getPaymentDetailSortedByAmount();
			
		if(payment.size()<=0) {
			throw new PaymentNotFoundException("Payment not exists ");
		}
		return ResponseEntity.of(Optional.of(payment));
	}
		
	//get all Payment handler sorted by amounts using native
	@GetMapping("payments/sort/native")
	public ResponseEntity<List<Payment>> getPaymentSortedByAmountUsingNative() throws PaymentNotFoundException {
		List<Payment> payment = paymentService.getPaymentSortedByAmountUsingNative();
			
		if(payment.size()<=0) {
			throw new PaymentNotFoundException("Payment not exists ");
		}
		return ResponseEntity.of(Optional.of(payment));
	}

	//get all Payment handler by amount
	@GetMapping("payments/amounts/{amount}")
	public ResponseEntity<List<Payment>> getPaymentByAmount(@PathVariable("amount") double amount) throws PaymentNotFoundException {
		List<Payment> payment = paymentService.getPaymentByAmount(amount);
			
		if(payment.size()<=0) {
			throw new PaymentNotFoundException("Payment not exists with amount = " + amount);
		}
		return ResponseEntity.of(Optional.of(payment));
	}
	
	//implementing paging
	@GetMapping("payments/paging")
	public ResponseEntity<List<Payment>> getPayments() throws PaymentNotFoundException{
		List<Payment> payment = paymentService.getPaymentsUsingPaging();
		
		if(payment.size()<=0) {
			throw new PaymentNotFoundException("Payment not exist");
		}
		return ResponseEntity.of(Optional.of(payment));
	}

	//sorting implementation
	@GetMapping("payments/sorting")
	public ResponseEntity<Iterable<Payment>> getSortPayments() throws PaymentNotFoundException {
		List<Payment> payment = (List<Payment>) paymentService.getSortPaymentsUsingSorting();
		
		if(payment.size()<=0) {
			throw new PaymentNotFoundException("Payment not exist");
		}
		return ResponseEntity.of(Optional.of(payment));
	}
	
}
