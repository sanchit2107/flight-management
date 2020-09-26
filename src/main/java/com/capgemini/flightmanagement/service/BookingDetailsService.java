package com.capgemini.flightmanagement.service;
import java.math.BigInteger;
import org.springframework.http.ResponseEntity;
import com.capgemini.flightmanagement.entity.BookingDetails;

public interface BookingDetailsService {

	public ResponseEntity<?> createBooking(BookingDetails newBooking,Integer userId, Integer scheduleId);

	public BookingDetails updateBooking(BookingDetails newBooking);

	public String deleteBooking(Integer bookingId);

	public Iterable<BookingDetails> displayAllBooking();

	public ResponseEntity<?> findBookingById(Integer bookingId);
	
	public ResponseEntity<?> findBookingByUserId(Integer userId);
	
}
