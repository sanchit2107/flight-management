package com.capgemini.flightmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.flightmanagement.entity.Passenger;

public interface PassengerDao extends JpaRepository<Passenger, Integer> {

}
