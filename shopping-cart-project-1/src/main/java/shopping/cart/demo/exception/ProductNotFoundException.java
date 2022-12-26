package shopping.cart.demo.exception;

public class ProductNotFoundException extends Exception {

	private static final long serialVersionUID = -7076854111898455591L;

	public ProductNotFoundException(String message) {
		super(message);
	}
}
