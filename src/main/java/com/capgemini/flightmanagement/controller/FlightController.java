/**
 * 
 */
package com.capgemini.flightmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.flightmanagement.entity.FlightDetails;
import com.capgemini.flightmanagement.exceptions.FlightDetailsAlreadyPresentException;
import com.capgemini.flightmanagement.exceptions.FlightDetailsNotFoundException;
import com.capgemini.flightmanagement.service.FlightDetailsService;

/**
 * @author Sanchit Singhal
 *
 */

@RestController
@RequestMapping("/flight")
public class FlightController {
	
	@Autowired(required=true)
	FlightDetailsService flightService;
	
	
	@PostMapping("/addFlightDetails")
	@ExceptionHandler(FlightDetailsAlreadyPresentException.class)
	public void addFlightDetails(@RequestBody FlightDetails flightObj) {
		
		flightService.addFlight(flightObj);
	}
	
	
	@GetMapping("/displayAllFlightDetails")
	public Iterable<FlightDetails> viewAllFlightDetails() {
		
		return flightService.viewAllFlight();
	}
	
	
	@GetMapping("/displayFlightDetailsByFlightNumber/{flightNumber}")
	@ExceptionHandler(FlightDetailsNotFoundException.class)
	public FlightDetails viewFlightByFlightNumber(@PathVariable("flightNumber") Integer flightNo) {
		
		return flightService.viewFlightByFlightNumber(flightNo);
	}
	
	
	@PutMapping("/updateFlightDetails")
	@ExceptionHandler(FlightDetailsNotFoundException.class)
	public void modifyFlightDetails(FlightDetails flightObj) {
		
		flightService.modifyFlight(flightObj);
	}
	
	
	@DeleteMapping("/deleteFlightDetails/{flightNumber}")
	@ExceptionHandler(FlightDetailsNotFoundException.class)
	public void removeFlightDetails(@PathVariable("flightNumber") Integer flightNo) {
		
		flightService.removeFlight(flightNo);
	}
	

}
