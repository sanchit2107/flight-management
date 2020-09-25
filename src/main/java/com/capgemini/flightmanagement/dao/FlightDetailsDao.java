package com.capgemini.flightmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.flightmanagement.entity.FlightDetails;

/**
 * @author Sanchit Singhal
 */
@Repository
public interface FlightDetailsDao extends JpaRepository<FlightDetails, Integer> {

}
