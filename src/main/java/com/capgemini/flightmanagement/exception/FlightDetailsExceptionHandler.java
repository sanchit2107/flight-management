/**
 * 
 */
package com.capgemini.flightmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Sanchit Singhal
 *
 */
@ControllerAdvice
public class FlightDetailsExceptionHandler {

	@ExceptionHandler(value= {NullFlightDetailsException.class})
	public ResponseEntity<ExceptionObject> handleNullFlightDetailsException(NullFlightDetailsException e){
		return new ResponseEntity<ExceptionObject>(new ExceptionObject(e.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {FlightDetailsAlreadyPresentException.class})
	public ResponseEntity<ExceptionObject> handleFlightDetailsAlreadyPresentException(FlightDetailsAlreadyPresentException e) {
		return new ResponseEntity<ExceptionObject>(new ExceptionObject(e.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {FlightDetailsNotFoundException.class})
	public ResponseEntity<ExceptionObject> handleFlightDetailsNotFoundException(FlightDetailsNotFoundException e) {
		return new ResponseEntity<ExceptionObject>(new ExceptionObject(e.getMessage(), HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
	}
	
}
