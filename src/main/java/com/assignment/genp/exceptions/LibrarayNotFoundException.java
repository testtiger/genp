package com.assignment.genp.exceptions;

public class LibrarayNotFoundException  extends  RuntimeException{

	/**
	 * 
	 */
	private String message;
	private static final long serialVersionUID = 2455476032034759956L;

	public LibrarayNotFoundException() {
		
	}
	public LibrarayNotFoundException(String message) {
		this.message=message;
	}
}
