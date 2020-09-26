/**
 * 
 */
package com.capgemini.flightmanagement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.flightmanagement.entity.FlightDetails;
import com.capgemini.flightmanagement.serviceImpl.FlightDetailsServiceImpl;

/**
 * @author Sanchit Singhal
 *
 */

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/flight")
public class FlightController {
	
	@Autowired(required=true)
	FlightDetailsServiceImpl flightService;
	
	
	@PostMapping("/addFlightDetails")
	public ResponseEntity<Void> addFlightDetails(@Valid @RequestBody FlightDetails flightObj) {
		
		flightService.addFlight(flightObj);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@GetMapping("/displayAllFlightDetails")
	public Iterable<FlightDetails> viewAllFlightDetails() {
		
		return flightService.viewAllFlight();
	}
	
	
	@GetMapping("/displayFlightDetailsByFlightNumber/{flightNumber}")
	public ResponseEntity<FlightDetails> viewFlightByFlightNumber(@PathVariable("flightNumber") Integer flightNo) {
		
		System.out.println(flightNo);
		FlightDetails flightDetailObj =  flightService.viewFlightByFlightNumber(flightNo);
		return ResponseEntity.ok(flightDetailObj);
	}
	
	
	@PostMapping("/updateFlightDetails")
	public ResponseEntity<Void> modifyFlightDetails(@Valid @RequestBody FlightDetails flightObj) {
		
		flightService.modifyFlight(flightObj);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deleteFlightDetails/{flightNumber}")
	public ResponseEntity<Void> removeFlightDetails(@PathVariable("flightNumber") Integer flightNo) {
		
		flightService.removeFlight(flightNo);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	

}
