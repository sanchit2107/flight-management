/**
 * 
 */
package com.capgemini.flightmanagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.flightmanagement.dao.FlightDetailsDao;
import com.capgemini.flightmanagement.entity.FlightDetails;
import com.capgemini.flightmanagement.exception.FlightDetailsAlreadyPresentException;
import com.capgemini.flightmanagement.exception.FlightDetailsNotFoundException;
import com.capgemini.flightmanagement.exception.NullFlightDetailsException;
import com.capgemini.flightmanagement.service.FlightDetailsService;

/**
 * @author Sanchit Singhal
 *
 */
@Service
public class FlightDetailsServiceImpl implements FlightDetailsService {

	@Autowired
	FlightDetailsDao flightDao;
	
	
	/*
	 * @author Sanchit Singhal
	 * ADD FLIGHT DETAILS
	 * @see com.capgemini.flightmanagement.service.FlightDetailsService#addFlight(com.capgemini.flightmanagement.entity.FlightDetails)
	 */
	@Override
	public void addFlight(FlightDetails flight) {
		
		if (flight == null)
			throw new NullFlightDetailsException("No data recieved");
		int flightId = (int) ((Math.random() * 9000) + 1000);
		flight.setFlightNumber(flightId);
		
		Optional<FlightDetails> findByFlightNumber = flightDao.findById(flight.getFlightNumber());		
		if (findByFlightNumber.isPresent())
			throw new FlightDetailsAlreadyPresentException("Flight Details already exists..");
		else {
			
			flightDao.save(flight);
		}
		System.out.println("Flight Details Added..");
		
	}

	
	/*
	 * @author Sanchit Singhal
	 * DISPLAY ALL FLIGHT DETAILS
	 * @see com.capgemini.flightmanagement.service.FlightDetailsService#viewAllFlight()
	 */
	@Override
	public Iterable<FlightDetails> viewAllFlight() {
		
		return flightDao.findAll();
	}

	
	/*
	 * @author Sanchit Singhal
	 * VIEW FLIGHT DETAILS by FlightNumber
	 * @see com.capgemini.flightmanagement.service.FlightDetailsService#viewFlightByFlightNumber(java.lang.Integer)
	 */
	@Override
	public FlightDetails viewFlightByFlightNumber(Integer flightNumber) {

		Optional<FlightDetails> findByFlightNumber = flightDao.findById(flightNumber);
		if(findByFlightNumber.isPresent()) {
			return findByFlightNumber.get();
		}
		else {
			throw new FlightDetailsNotFoundException("Flight Details with the flightNumber = " + flightNumber + " not exists!!");
		}
	}

	
	/*
	 * @author Sanchit Singhal
	 * UPDATE FLIGHT DETAILS
	 * @see com.capgemini.flightmanagement.service.FlightDetailsService#modifyFlight(com.capgemini.flightmanagement.entity.FlightDetails)
	 */
	@Override
	public void modifyFlight(FlightDetails flight) {
		
		if(flight == null)
			throw new NullFlightDetailsException("No data recieved..");
		Optional<FlightDetails> findByFlightNumber = flightDao.findById(flight.getFlightNumber());
		if (findByFlightNumber.isPresent()) {
			flightDao.save(flight);
		} else
			throw new FlightDetailsNotFoundException("Flight with flightNumber: " + flight.getFlightNumber() + " not exists..");
	}
	

	/*
	 * @author Sanchit Singhal
	 * DELETE FLIGHT DETAILS using flightNumber
	 * @see com.capgemini.flightmanagement.service.FlightDetailsService#removeFlight(java.lang.Integer)
	 */
	@Override
	public void removeFlight(Integer flightNumber) {
		
		if(flightNumber == null) 
			throw new NullFlightDetailsException("No data recieved..");
		FlightDetails flightObj = flightDao.getOne(flightNumber);
		if (flightObj == null)
			throw new FlightDetailsNotFoundException("Flight Details not found");
		flightDao.deleteById(flightNumber);
	}
	
	public ResponseEntity<FlightDetails> findByRouteDate(String arrivalAirport,String departureAirport,String date) {
		List<FlightDetails> list = flightDao.findByRouteDate(arrivalAirport.toLowerCase(), departureAirport.toLowerCase());
		for (FlightDetails f : list) {
			if(f.getDepartureDate().equals(date)) {
				return ResponseEntity.ok().body(f);
			}
		}
		throw new FlightDetailsNotFoundException("details not found");
	}
}
