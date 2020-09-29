package com.capgemini.flightmanagement.service;

import java.util.List;

import com.capgemini.flightmanagement.entity.BookingDetails;
import com.capgemini.flightmanagement.entity.FlightDetails;
import com.capgemini.flightmanagement.entity.User;

import com.capgemini.flightmanagement.utils.UserAuth;

public interface UserSevice {
	public User addUser(User user);

	public void updateUser(User user);

	public User getUser(Integer userId);

	public void deleteUser(Integer userId);

	public User userLogin(UserAuth auth);

	public BookingDetails addBooking(BookingDetails booking, Integer userId, Integer flightNumber);

	public void deleteBooking(Integer bookingId, Integer userId);

	public List<BookingDetails> getBookingByUserId(Integer userId);

	public FlightDetails findByRouteAndDate(String arrivalAirport, String departureAirport, String date);

}
