package com.capgemini.flightmanagement.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.flightmanagement.entity.BookingDetails;
import com.capgemini.flightmanagement.entity.FlightDetails;
import com.capgemini.flightmanagement.entity.User;
import com.capgemini.flightmanagement.exception.UserDoesnotExistException;
import com.capgemini.flightmanagement.exception.UserValidationException;
import com.capgemini.flightmanagement.serviceImpl.UserServiceImpl;
import com.capgemini.flightmanagement.utils.UserAuth;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl service;
	

	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user, Errors error) {
		if (error.hasErrors()) {
			throw new UserValidationException("invalid data provided");
		}
		User addedUser =  service.addUser(user);
		return ResponseEntity.ok().body(addedUser);
	}

	@PostMapping("/userLogin")
	public ResponseEntity<User> loginUser(@RequestBody UserAuth auth) {
		User user = service.userLogin(auth);
		return ResponseEntity.ok().body(user);
		
	}

	@GetMapping("/getUser/{id}")
	public ResponseEntity<User> getUser(@PathVariable Integer id) {
		
		User user = service.getUser(id);
		return ResponseEntity.ok(user);
	}

	@PostMapping("/updateUser")
	public ResponseEntity<Void> updateUser(@Valid @RequestBody User user) {
		service.updateUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
		service.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping("/addBooking/{userId}/{flightNumber}")
	public ResponseEntity<BookingDetails> addBooking(@RequestBody BookingDetails booking,@PathVariable Integer userId,@PathVariable Integer flightNumber){
		BookingDetails details = service.addBooking(booking, userId, flightNumber);
		return ResponseEntity.ok().body(details);
	}
	
	@DeleteMapping("/deleteBooking/{bookingId}/{userId}")
	public void deleteBooking(@PathVariable Integer bookingId,@PathVariable Integer userId) {
		service.deleteBooking(bookingId, userId);
	}
	
	@GetMapping("/findFlight/{arrivalAirport}/{departureAirport}/{date}")
	public ResponseEntity<FlightDetails> findByRouteAndDate(@PathVariable String arrivalAirport,@PathVariable String departureAirport,@PathVariable String date){
		FlightDetails details = service.findByRouteAndDate(arrivalAirport, departureAirport, date);
		return ResponseEntity.ok().body(details);
	}
	
	@GetMapping("/getBookingByUser/{userId}")
	public ResponseEntity<List<BookingDetails>> getBookingByUser(@PathVariable Integer userId){
		List<BookingDetails> list = service.getBookingByUserId(userId);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/getFlightByNumber/{flightNumber}")
	public ResponseEntity<FlightDetails> getFlightByNumber(@PathVariable Integer flightNumber){
		FlightDetails details = service.getFlightByFlightNumber(flightNumber);
		return ResponseEntity.ok().body(details);
	}
}
