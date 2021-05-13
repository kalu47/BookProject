package com.ust.book.exception;

public class BookAlreadyExistException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public BookAlreadyExistException (String message) {
		super(message);
	}
}
