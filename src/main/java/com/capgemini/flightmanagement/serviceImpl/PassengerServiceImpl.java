package com.capgemini.flightmanagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.flightmanagement.dao.PassengerDao;
import com.capgemini.flightmanagement.entity.Passenger;
import com.capgemini.flightmanagement.service.PassengerService;

@Service
public class PassengerServiceImpl implements PassengerService {
	
	@Autowired
	PassengerDao dao;

	@Override
	public Passenger getPassengerById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Passenger> passenger = dao.findById(id);
		return passenger.get();
		
	}

	@Override
	public List<Passenger> getAllPassengers() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
