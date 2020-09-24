/**
 * 
 */
package com.capgemini.flightmanagement.exceptions;

/**
 * @author Sanchit Singhal
 *
 */
public class FlightDetailsAlreadyPresentException extends RuntimeException {

	/**
	 * @param message
	 * @author Sanchit Singhal
	 */
	public FlightDetailsAlreadyPresentException(String message) {
		super(message);
	}

}
