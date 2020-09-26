package com.capgemini.flightmanagement.serviceImpl;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.capgemini.flightmanagement.dao.BookingDetailsDao;
import com.capgemini.flightmanagement.dao.UserDao;
import com.capgemini.flightmanagement.entity.BookingDetails;
import com.capgemini.flightmanagement.exception.RecordAlreadyPresentException;
import com.capgemini.flightmanagement.exception.RecordNotFoundException;
import com.capgemini.flightmanagement.service.BookingDetailsService;
import com.capgemini.flightmanagement.entity.*;

/***
 * @author Sameeksha Janghela
 */
@Service
@Transactional
public class BookingDetailsServiceImpl implements BookingDetailsService {

	/*
	 * Creating DAO object
	 */
	@Autowired
	BookingDetailsDao bookingDao;
	
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	FlightDetailsServiceImpl flightService;

	/*
	 * making new Booking
	 * throw exception if booking is already present
	 * 
	 */
	@Override
	public ResponseEntity<?> createBooking(BookingDetails newBooking,Integer userId,Integer flightNumber) {

//		Optional<BookingDetails> findBookingById = bookingDao.findById(newBooking.getBookingId());
//		try {
//			if (!findBookingById.isPresent()){
//				User user = userService.getUser(userId);
//				FlightDetails flightDetails = flightService.viewFlightByFlightNumber(flightNumber);
//				newBooking.setUser(user);
//				newBooking.setFlightDetails(flightDetails);
//				bookingDao.save(newBooking);
//				return new ResponseEntity<BookingDetails>(newBooking, HttpStatus.OK);
//			} else
//				throw new RecordAlreadyPresentException(
//						"Booking with Booking Id: " + newBooking.getBookingId() + " already exists!!");
//		} catch (RecordAlreadyPresentException e) {
//
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
		User user = userService.getUser(userId);
		newBooking.setUser(user);
		FlightDetails flightDetails = flightService.viewFlightByFlightNumber(flightNumber);
		newBooking.setFlightDetails(flightDetails);
		List<BookingDetails> bookingList = user.getBookingDetails();
		bookingList.add(newBooking);
		user.setBookingDetails(bookingList);
		userService.updateUser(user);
		return new ResponseEntity<BookingDetails>(newBooking, HttpStatus.OK);
		
	}

	/*
	 * update booking made
	 * throw exception if booking not found
	 */
	@Override
	public BookingDetails updateBooking(BookingDetails changedBooking) {
		Optional<BookingDetails> findBookingById = bookingDao.findById(changedBooking.getBookingId());
		if (findBookingById.isPresent()) {
			bookingDao.save(changedBooking);
		} else
			throw new RecordNotFoundException(
					"Booking with Booking Id: " + changedBooking.getBookingId() + " not exists!!");
		return changedBooking;
	}

	/*
	 * throw exception if booking is not found
     * else delete the booking if exist in database
	 */
	@Override
	public String deleteBooking(Integer bookingId) {
		Optional<BookingDetails> findBookingById = bookingDao.findById(bookingId);
		if (findBookingById.isPresent()) {
			bookingDao.deleteById(bookingId);
			return "Booking Deleted!!";
		} else
			throw new RecordNotFoundException("Booking not found for the entered BookingID");
	}

	/*
	 *  show all booking
	 */
	@Override
	public Iterable<BookingDetails> displayAllBooking() {
		return bookingDao.findAll();
	}

	/*
	 * 
	 *  find booking by booking ID
	 */
	@Override
	public ResponseEntity<?> findBookingById(Integer bookingId) {
		Optional<BookingDetails> findById = bookingDao.findById(bookingId);
		try {
			if (findById.isPresent()) {
				BookingDetails findBooking = findById.get();
				return new ResponseEntity<BookingDetails>(findBooking, HttpStatus.OK);
			} else
				throw new RecordNotFoundException("No record found with ID " + bookingId);
		} catch (RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public ResponseEntity<?> findBookingByUserId(Integer userId) {
		User user = userService.getUser(userId);
		List<BookingDetails> bookingDetails = user.getBookingDetails();
		return ResponseEntity.ok(bookingDetails);
	}
}

 
