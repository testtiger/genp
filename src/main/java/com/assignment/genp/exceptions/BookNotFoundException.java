package com.assignment.genp.exceptions;

public class BookNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private String message;
	private static final long serialVersionUID = 2455476032034759956L;

	public BookNotFoundException() {
		
	}
	public BookNotFoundException(String message) {
		this.message=message;
	}

}
