/**
 * 
 */
package com.capgemini.flightmanagement.service;


import org.springframework.stereotype.Service;

import com.capgemini.flightmanagement.entity.FlightDetails;

/**
 * @author Sanchit Singhal
 *
 */
@Service
public interface FlightDetailsService {
	
	public void addFlight(FlightDetails flight);

	public Iterable<FlightDetails> viewAllFlight();

	public FlightDetails viewFlightByFlightNumber(Integer flightNumber);

	public void modifyFlight(FlightDetails flight);

	public void removeFlight(Integer flightNumber);

}
