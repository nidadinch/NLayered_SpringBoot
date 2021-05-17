package app4l.demo.business.exceptions;

public class ProductNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException() {
		
	}
	
	public ProductNotFoundException(String message) {
		super(message);	
	}
	
	public ProductNotFoundException(String message, Throwable cause) {
		super(message, cause);	
	}

	public ProductNotFoundException(Throwable cause) {
		super(cause);	
	}
	
}
