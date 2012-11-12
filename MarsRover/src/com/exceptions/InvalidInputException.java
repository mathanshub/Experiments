package com.exceptions;

public class InvalidInputException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidInputException() {
		super();
	}

	public InvalidInputException(String msg) {
		super(msg);
	}
}