package io.neha.movieflix.Exception;

public class MovieNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2635566054774748720L;
	public MovieNotFoundException(String message){
		super(message);
	}
	public MovieNotFoundException(String message, Throwable cause){
		super(message, cause);
	}
}
