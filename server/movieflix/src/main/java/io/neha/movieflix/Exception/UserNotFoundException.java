package io.neha.movieflix.Exception;

public class UserNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1982668361437975106L;
	public UserNotFoundException(String message){
		super(message);
	}
	public UserNotFoundException(String message, Throwable cause){
		super(message, cause);
	}
}
