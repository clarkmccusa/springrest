package com.mcc.springrest.exception;

public class BookNotFoundException extends RuntimeException{

	public BookNotFoundException( String message ){
		super(message);
	}
	
}
