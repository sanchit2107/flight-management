package com.capgemini.flightmanagement.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.flightmanagement.entity.Flight;

/**
 * @author Sanchit Singhal
 *
 */
@Repository
public interface FlightDao extends JpaRepository<Flight, BigInteger>{

}
