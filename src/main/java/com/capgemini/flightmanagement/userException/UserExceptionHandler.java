package com.capgemini.flightmanagement.userException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(value = {NullUserException.class})
	public ResponseEntity<RuntimeException> handleNullUserException(NullUserException e){
		return new ResponseEntity<RuntimeException>(e, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {UserAlreadyExistException.class})
	public ResponseEntity<RuntimeException> handleUserAlreadyExistException(UserAlreadyExistException e){
		return new ResponseEntity<RuntimeException>(e, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {UserDoesnotExistException.class})
	public ResponseEntity<RuntimeException> handleUserDoesnotExistException(UserDoesnotExistException e){
		return new ResponseEntity<RuntimeException>(e, HttpStatus.NOT_FOUND);
	}
}
