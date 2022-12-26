package shopping.cart.demo.exception;

public class OrderNotFoundException extends Exception{

	private static final long serialVersionUID = -7076854111898455591L;

	public OrderNotFoundException(String message) {
		super(message);
	}
}
