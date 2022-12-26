package com.shoppingcart.app.exception;

public class OrderDetailNotFoundException extends Exception {
	
	private static final long serialVersionUID = -7076854111898455591L;

	public OrderDetailNotFoundException(String message) {
		super(message);
	}
}
