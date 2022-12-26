package shopping.cart.demo.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import shopping.cart.demo.controller.PaymentController;
import shopping.cart.demo.exception.PaymentNotFoundException;
import shopping.cart.demo.model.Payment;

@Controller
public class PaymentMain {

	@Autowired
	private PaymentController paymentController;
	
private static List<Payment> payments = new ArrayList<Payment>();
	
	public void paymentRun() {
		System.out.println("\n Payment Entity records :");
		addPayments(createPayments());
	}

	//method to add Payment
	private void addPayments(List<Payment> payments) {
		for(Payment payment : payments) {
			try {
				paymentController.addPayment(payment);
			} 
			catch (PaymentNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//method to create List of Payment
	private List<Payment> createPayments(){
		Payment py1 = new Payment(null, 600.08, null);
		Payment py2 = new Payment(null, 435.08, null);
		Payment py3 = new Payment(null, 600.08, null);
		Payment py4 = new Payment(null, 600.08, null);
		Payment py5 = new Payment(null, 600.08, null);
	
		payments.add(py1);
		payments.add(py2);
		payments.add(py3);
		payments.add(py4);
		payments.add(py5);

		return payments;
	}

}
