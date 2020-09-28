package com.capgemini.flightmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.flightmanagement.entity.Passenger;
import com.capgemini.flightmanagement.serviceImpl.PassengerServiceImpl;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

	@Autowired
	PassengerServiceImpl service;
	
	@GetMapping("/getPassengerById/{id}")
	public Passenger getById(@PathVariable Integer id) {
		return service.getPassengerById(id);
	}
	
	@GetMapping("/getAllPassengers")
	public List<Passenger> getAll(){
		return service.getAllPassengers();
	}
}
