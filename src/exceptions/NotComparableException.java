package exceptions;

public class NotComparableException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1562190595961618914L;
	
	public NotComparableException() {
		// empty constructor
	}
	
	public NotComparableException(String message) {
		super(message);
	}

}
