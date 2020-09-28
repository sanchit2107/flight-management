package com.capgemini.flightmanagement.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.capgemini.flightmanagement.entity.BookingDetails;

public interface BookingDetailsService {

	public ResponseEntity<?> createBooking(BookingDetails newBooking,Integer userId, Integer scheduleId);

	public BookingDetails updateBooking(BookingDetails newBooking);

	public String deleteBooking(Integer bookingId,Integer userId);

	public Iterable<BookingDetails> displayAllBooking();

	public ResponseEntity<?> findBookingById(Integer bookingId);
	
	public ResponseEntity<List<BookingDetails>> findBookingByUserId(Integer userId);
	
}
