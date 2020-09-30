package com.capgemini.flightmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdminExceptionHandler {
	
	@ExceptionHandler(value = {NullAdminException.class})
	public ResponseEntity<ExceptionObject> handleNullAdminException (NullAdminException e){
		return new ResponseEntity<ExceptionObject>(new ExceptionObject(e.getMessage(), HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {AdminAlreadyExistException.class})
	public ResponseEntity<ExceptionObject> handleAdminAlreadyExistException(AdminAlreadyExistException e){
		return new ResponseEntity<ExceptionObject>(new ExceptionObject(e.getMessage(), HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);		
	}
	
	@ExceptionHandler(value = {AdminDoesnotExistException.class})
	public ResponseEntity<ExceptionObject> handleAdminDoesnotExistException(AdminDoesnotExistException e){
		return new ResponseEntity<ExceptionObject>(new ExceptionObject(e.getMessage(),HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = {BookingDoesNotFoundException.class})
	public ResponseEntity<ExceptionObject> handleBookingException(BookingDoesNotFoundException e){
		return new ResponseEntity<ExceptionObject>(new ExceptionObject(e.getMessage(),HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
	}
}
