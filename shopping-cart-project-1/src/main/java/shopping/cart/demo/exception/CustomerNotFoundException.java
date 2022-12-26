package shopping.cart.demo.exception;

public class CustomerNotFoundException extends Exception {

	private static final long serialVersionUID = -7076854111898455591L;

	public CustomerNotFoundException(String message) {
		super(message);
	}
}
