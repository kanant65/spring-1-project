package shopping.cart.demo.controller;

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

import shopping.cart.demo.exception.PaymentNotFoundException;
import shopping.cart.demo.model.Payment;
import shopping.cart.demo.repository.PaymentRepository;

@RestController
@RequestMapping("/api/v1/")
public class PaymentController {

	@Autowired
	private PaymentRepository paymentRepository;

	//get all Payment handler
	@GetMapping("/payments")
	public ResponseEntity<List<Payment>> getAllPayments() throws PaymentNotFoundException {
		List<Payment> list = paymentRepository.findAll();
		
		if(list.size()<=0) {
			throw new PaymentNotFoundException("Payment not exist");
		}
		return ResponseEntity.of(Optional.of(list));
	}

	//get single Payment handler
	@GetMapping("/payments/{id}")
	public ResponseEntity<Payment> getPayment(@PathVariable("id") Long id) throws PaymentNotFoundException  {
		Payment payment = paymentRepository.findById(id)
				 .orElseThrow(() -> new PaymentNotFoundException("Payment not exist with id:" + id));
		
		if(payment == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(payment));
	}
	
	//new Payment handler
	@PostMapping("/payments")
	public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) throws PaymentNotFoundException {
		Payment p = paymentRepository.save(payment);
		
		if(paymentRepository.save(payment) == null) {
			throw new PaymentNotFoundException("Payment not get inserted");
		}
		return ResponseEntity.of(Optional.of(p));
	}
	
	//delete Payment handler
	@DeleteMapping("/payments/{paymentId}")
	public ResponseEntity<Void> deletePayment(@PathVariable("paymentId") Long paymentId) throws PaymentNotFoundException {
		
		Payment payment = paymentRepository.findById(paymentId)
				 .orElseThrow(() -> new PaymentNotFoundException("Payment not exist with id:" + paymentId));
		
		paymentRepository.delete(payment);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	//update Payment handler
	@PutMapping("/payments/{paymentId}")
	public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment, @PathVariable("employeeId") Long paymentId) throws PaymentNotFoundException {
		
		Payment updatePayment = paymentRepository.findById(paymentId)
				 .orElseThrow(() -> new PaymentNotFoundException("Payment not exist with id:" + paymentId));
		
		updatePayment.setCheckNumber(paymentId);
		paymentRepository.save(payment);
		
		return ResponseEntity.ok(updatePayment);
		
	}

	//get all Payment handler sorted by amount
	@GetMapping("payments/sort")
	public ResponseEntity<List<Payment>> getPaymentDetailSortedByQuantity() throws PaymentNotFoundException {
		List<Payment> list = paymentRepository.findAllSortedByAmount();
			
		if(list.size()<=0) {
			throw new PaymentNotFoundException("Payment not exists ");
		}
		return ResponseEntity.of(Optional.of(list));
	}
		
	//get all Payment handler sorted by amounts using native
	@GetMapping("payments/sort/native")
	public ResponseEntity<List<Payment>> getPaymentSortedByNameUsingNative() throws PaymentNotFoundException {
		List<Payment> list = paymentRepository.findAllSortedByAmountUsingNative();
			
		if(list.size()<=0) {
			throw new PaymentNotFoundException("Payment not exists ");
		}
		return ResponseEntity.of(Optional.of(list));
	}	
}
