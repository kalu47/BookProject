package com.ust.book.exception;

public class UserUnauthorisedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserUnauthorisedException(String message) {
		super(message);
	}
}
