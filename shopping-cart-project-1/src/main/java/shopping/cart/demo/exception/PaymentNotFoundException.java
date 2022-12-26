package shopping.cart.demo.exception;

public class PaymentNotFoundException extends Exception {

	private static final long serialVersionUID = -7076854111898455591L;

	public PaymentNotFoundException(String message) {
		super(message);
	}
}
