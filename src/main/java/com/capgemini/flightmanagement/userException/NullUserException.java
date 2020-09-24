package com.capgemini.flightmanagement.userException;

public class NullUserException extends RuntimeException {

	public NullUserException(String message, Throwable throwable) {
		super(message,throwable);
		// TODO Auto-generated constructor stub
	}

	public NullUserException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
