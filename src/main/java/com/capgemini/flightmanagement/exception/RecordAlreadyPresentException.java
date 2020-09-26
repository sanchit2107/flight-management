package com.capgemini.flightmanagement.exception;
/**
 * @author Sameeksha Janghela
 *
 */
public class RecordAlreadyPresentException extends RuntimeException {
	public RecordAlreadyPresentException(String s) {
		super(s);
	}
}
