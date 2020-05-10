package com.assignment.genp.repository;

public class RepositoryException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RepositoryException(String message, Throwable error) {
		super(message,error);
	}
	
	public RepositoryException(String message) {
		super(message);
	}
	
	

}
