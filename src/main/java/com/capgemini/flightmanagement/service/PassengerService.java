package com.capgemini.flightmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.flightmanagement.entity.Passenger;

@Service
public interface PassengerService {
	
	public Passenger getPassengerById(Integer id);
	
	public List<Passenger> getAllPassengers();
	
}
