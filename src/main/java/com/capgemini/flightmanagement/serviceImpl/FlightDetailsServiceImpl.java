/**
 * 
 */
package com.capgemini.flightmanagement.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.flightmanagement.dao.FlightDetailsDao;
import com.capgemini.flightmanagement.entity.FlightDetails;
import com.capgemini.flightmanagement.exceptions.FlightDetailsAlreadyPresentException;
import com.capgemini.flightmanagement.exceptions.FlightDetailsNotFoundException;
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
	public ResponseEntity<?> addFlight(FlightDetails flight) {
		
		Optional<FlightDetails> findByFlightNumber = flightDao.findById(flight.getFlightNumber());
		try {
			if(!findByFlightNumber.isPresent()) {
				flightDao.save(flight);
				return new ResponseEntity<FlightDetails>(flight, HttpStatus.OK);
			}
			else {
				throw new FlightDetailsAlreadyPresentException("Flight Details with flightNumber = " 
						+ flight.getFlightNumber() + " already present!!");
			}
		}
		catch(FlightDetailsNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
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
	public FlightDetails modifyFlight(FlightDetails flight) {
		
		Optional<FlightDetails> findByFlightNumber = flightDao.findById(flight.getFlightNumber());
		if (findByFlightNumber.isPresent()) {
			flightDao.save(flight);
		} else
			throw new FlightDetailsNotFoundException("Flight with flightNumber: " + flight.getFlightNumber() + " not exists");
		return flight;
	}
	

	/*
	 * @author Sanchit Singhal
	 * DELETE FLIGHT DETAILS using flightNumber
	 * @see com.capgemini.flightmanagement.service.FlightDetailsService#removeFlight(java.lang.Integer)
	 */
	@Override
	public String removeFlight(Integer flightNumber) {
		
		Optional<FlightDetails> findByFlightNumber = flightDao.findById(flightNumber);
		if(findByFlightNumber.isPresent()) {
			flightDao.deleteById(flightNumber);
			return "Flight with flightNumber " + flightNumber + " deleted!!";
		}
		else {
			throw new FlightDetailsNotFoundException("Flight with flightNumber: " + flightNumber + " not exists");
		}
	}

}
