/**
 * 
 */
package com.capgemini.flightmanagement.service;

import org.springframework.http.ResponseEntity;

import com.capgemini.flightmanagement.entity.FlightDetails;

/**
 * @author Sanchit Singhal
 *
 */
public interface FlightDetailsService {
	
	public ResponseEntity<?> addFlight(FlightDetails flight);

	public Iterable<FlightDetails> viewAllFlight();

	public FlightDetails viewFlightByFlightNumber(Integer flightNumber);

	public FlightDetails modifyFlight(FlightDetails flight);

	public String removeFlight(Integer flightNumber);

}
