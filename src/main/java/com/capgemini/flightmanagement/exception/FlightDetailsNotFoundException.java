/**
 * 
 */
package com.capgemini.flightmanagement.exception;

/**
 * @author Sanchit Singhal
 *
 */
public class FlightDetailsNotFoundException extends RuntimeException {
	/**
	 * @param message
	 * @param cause
	 */
	public FlightDetailsNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public FlightDetailsNotFoundException(String s) {
		super(s);
	}

}
