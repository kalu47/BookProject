package com.ust.book.exception;

public class BookNotFoundException extends Exception{

	public static final long serialVersionUID = 1L;
	public BookNotFoundException (String message) {
		super(message);
	}
}
