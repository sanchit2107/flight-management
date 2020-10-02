package com.capgemini.flightmanagement.serviceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.flightmanagement.dao.BookingDetailsDao;
import com.capgemini.flightmanagement.dao.FlightDetailsDao;
import com.capgemini.flightmanagement.dao.PassengerDao;
import com.capgemini.flightmanagement.dao.UserDao;
import com.capgemini.flightmanagement.entity.BookingDetails;
import com.capgemini.flightmanagement.entity.FlightDetails;
import com.capgemini.flightmanagement.entity.Passenger;
import com.capgemini.flightmanagement.entity.User;
import com.capgemini.flightmanagement.exception.FlightDetailsNotFoundException;
import com.capgemini.flightmanagement.exception.NullFlightDetailsException;
import com.capgemini.flightmanagement.exception.NullUserException;
import com.capgemini.flightmanagement.exception.PassengerNotFoundException;
import com.capgemini.flightmanagement.exception.UserAlreadyExistException;
import com.capgemini.flightmanagement.exception.UserDoesnotExistException;
import com.capgemini.flightmanagement.service.UserService;
import com.capgemini.flightmanagement.utils.UserAuth;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;

	@Autowired
	FlightDetailsDao flightDao;

	@Autowired
	BookingDetailsDao bookingDao;
	
	@Autowired
	PassengerDao passengerDao;

	@Override
	public User addUser(User user) {

		if (user == null)
			throw new NullUserException("No data recieved");
		Integer userId = (int) ((Math.random() * 900) + 100);
		user.setUserId(userId);
		Optional<User> checkUser = userDao.findById(user.getUserId());
		if (checkUser.isPresent())
			throw new UserAlreadyExistException("user already exists");

		userDao.save(user);
		System.out.println("user Added");
		return user;

	}

	
	@Override
	public void updateUser(User user) {
		if (user == null)
			throw new NullUserException("No data recieved");
		Optional<User> checkUser = userDao.findById(user.getUserId());
		if (checkUser.isPresent())
			userDao.save(user);
		else
			throw new UserDoesnotExistException("User not found");

	}

	
	@Override
	public User getUser(Integer userId) {
		if (userId == null)
			throw new NullUserException("No data recieved");
		Optional<User> user = userDao.findById(userId);
		if (!user.isPresent())
			throw new UserDoesnotExistException("User not found");
		return user.get();
	}

	
	@Override
	public void deleteUser(Integer userId) {
		if (userId == null)
			throw new NullUserException("No data recieved");
		Optional<User> user = userDao.findById(userId);
		if (!user.isPresent())
			throw new UserDoesnotExistException("User not found");
		userDao.deleteById(userId);
	}

	
	@Override
	public User userLogin(UserAuth auth) {
		if (auth == null) {
			throw new NullUserException("No data recieved");
		}
		Optional<User> user = userDao.findById(auth.getUserId());
		if (user.isPresent()) {
			if (user.get().getUserId() == auth.getUserId() && user.get().getPassword().equals(auth.getPassword())) {
				return user.get();
			} else {
				throw new UserDoesnotExistException("invalid login id or password");
			}
			
		} else {
			throw new UserDoesnotExistException("User not found");
		}
	}

	@Override
	public BookingDetails addBooking(BookingDetails booking, Integer userId, Integer flightNumber) {
		Optional<User> user = userDao.findById(userId);
		Optional<FlightDetails> flight = flightDao.findById(flightNumber);
		if (!user.isPresent()) {
			throw new UserDoesnotExistException("user id not found");
		}
		if (!flight.isPresent()) {
			throw new FlightDetailsNotFoundException("flight details not found");
		}
		Integer bookingId = (int) ((Math.random() * 9000) + 1000);
		booking.setBookingId(bookingId);
		booking.setOwnerId(userId);
		booking.setFlightNumber(flightNumber);
		booking.setBookingDate(LocalDate.now().toString());
		booking.setBookingTime(LocalTime.now().toString().substring(0, 5));
		booking.setTotalCost(flight.get().getCost() * booking.getPassengers().size());
		List<BookingDetails> bookingList = user.get().getBookingDetails();
		bookingList.add(booking);
		user.get().setBookingDetails(bookingList);
		updateUser(user.get());
		return bookingDao.getOne(bookingId);
	}

	@Override
	public void deleteBooking(Integer bookingId, Integer userId) {
		Optional<User> u = userDao.findById(userId);
		Optional<BookingDetails> bd = bookingDao.findById(bookingId);
		if (!bd.isPresent()) {
			throw new UserDoesnotExistException("booking not found");
		}
		if (!u.isPresent()) {
			throw new UserDoesnotExistException("user id not found");
		}
		User user = u.get();
		List<BookingDetails> bookingList = user.getBookingDetails();
		BookingDetails deleteBooking = null;
		for (BookingDetails b : bookingList) {
			if (b.getBookingId() == bookingId) {
				System.out.println("booking id found");
				deleteBooking = b;
			}
		}
		bookingList.remove(deleteBooking);
		user.setBookingDetails(bookingList);
		bookingDao.deleteById(bookingId);
		updateUser(user);
	}

	@Override
	public List<BookingDetails> getBookingByUserId(Integer userId) {
		Optional<User> user = userDao.findById(userId);
		if (!user.isPresent()) {
			throw new UserDoesnotExistException("user id not found");
		}
		return user.get().getBookingDetails();
	}

	@Override
	public FlightDetails findByRouteAndDate(String arrivalAirport, String departureAirport, String date) {
		List<FlightDetails> list = flightDao.findByRouteDate(arrivalAirport.toLowerCase(),
				departureAirport.toLowerCase());
		for (FlightDetails f : list) {
			if (f.getDepartureDate().equals(date)) {
				return f;
			}
		}
		throw new FlightDetailsNotFoundException("details not found");
	}
	
	
	@Override
	public FlightDetails getFlightByFlightNumber(Integer flightNumber) {
		if (flightNumber == null) {
			throw new NullFlightDetailsException("no data privided");
		}
		Optional<FlightDetails> details = flightDao.findById(flightNumber);
		if (!details.isPresent()) {
			throw new FlightDetailsNotFoundException("no flight found for given number");
		}
		return details.get();
	}
	
	@Override
	public Passenger updatePassenger(Passenger passenger) {
		if (passenger == null) {
			throw new PassengerNotFoundException("no data provided");
		}
		Optional<Passenger> oldPassenger = passengerDao.findById(passenger.getPassengerId()); 
		if (!oldPassenger.isPresent()) {
			throw new PassengerNotFoundException("passenger not found");
		}
		passengerDao.save(passenger);
		return passenger;
	}

}
