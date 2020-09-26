package com.capgemini.flightmanagement.controller;

import java.math.BigInteger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.flightmanagement.service.BookingDetailsService;
import com.capgemini.flightmanagement.entity.BookingDetails;
import com.capgemini.flightmanagement.exception.RecordAlreadyPresentException;
import com.capgemini.flightmanagement.exception.RecordNotFoundException;

/***
 * @author Sameeksha Janghela
 */

@CrossOrigin("http://localhost:4200")
@ComponentScan(basePackages = "com")
@RestController
@RequestMapping("/booking")
public class BookingRestController {

	@Autowired
	private BookingDetailsService bookingService;
	
    private static final Logger Log = LoggerFactory.getLogger(BookingRestController.class);

	@PostMapping("/create/{user_id}/{flight_id}")
	public void addBooking(@RequestBody BookingDetails newBooking, @PathVariable Integer userId,@PathVariable Integer flightId) {
	     //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	     //LocalDate bookingDate = LocalDate.parse(BookingDetails.getBookingDate(), formatter);


		bookingService.createBooking(newBooking,userId,flightId);
	}

	@GetMapping("/readAllBooking")
	public Iterable<BookingDetails> readAllBookings() {

		return bookingService.displayAllBooking();
	}

	@PutMapping("/updateBooking")
	public void modifyBooking(@RequestBody BookingDetails updateBooking) {

		bookingService.updateBooking(updateBooking);
	}

	@GetMapping("/searchBooking/{id}")
	public ResponseEntity<?> searchBookingByID(@PathVariable("id") Integer bookingId) {

		return bookingService.findBookingById(bookingId);
	}

	@DeleteMapping("/deleteBooking/{id}")
	public void deleteBookingByID(@PathVariable("id") Integer bookingId) {

		bookingService.deleteBooking(bookingId);
	}
}