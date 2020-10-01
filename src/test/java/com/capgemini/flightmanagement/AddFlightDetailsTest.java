package com.capgemini.flightmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgemini.flightmanagement.dao.FlightDetailsDao;
import com.capgemini.flightmanagement.entity.FlightDetails;
import com.capgemini.flightmanagement.service.AdminService;

/*
 * @author Sanchit Singhal
 * Mockito Test Cases for FlightDetails
 */

@SpringBootTest
public class AddFlightDetailsTest {

	
	@Autowired
	private AdminService flightService;
	
	@MockBean
	private FlightDetailsDao repository;
	
	/*
	 * Testing getAllFlightDetails()
	 */
	@Test
	public void testGetFlightDetails() {
		when(repository.findAll()).thenReturn(Stream
				.of(new FlightDetails("delhi", "mumabi", 25, "01-11-2020", "01-11-2020", 
						"23:00", "17:00", "indoGo", 7899.00)).collect(Collectors.toList()));
		assertEquals(1, flightService.getAllFlightDetails().size());
	}
	
	
	/*
	 * Testing getAllFlightDetails() method
	 */
	@Test
	public void testDisplayAllFlightDetails() {
		when(repository.findAll()).thenReturn(Stream
				.of(new FlightDetails("delhi", "mumabi", 25, "01-11-2020", "01-22-2020", "23:00", 
						"17:00", "indoGo", 7899.00), 
						new FlightDetails("bangalore", "kolkatta", 48, "02-12-2020", "03-12-2020", 
								"05:20", "23:05", "spiceJet", 12899.00)).collect(Collectors.toList()));
		assertEquals(2, flightService.getAllFlightDetails().size());
	}
	
	
	/*
	 * Testing addFlightDetails() method
	 */
	@Test
	public void testAddFlightDetails() {
		
		FlightDetails flightObj = new FlightDetails("pune", "delhi", 56, "25-12-2020", "26-12-2020", 
				"05:00", "23:55", "indianAirways", 9899.55);
		when(repository.save(flightObj)).thenReturn(flightObj);
		assertEquals(flightObj, flightService.addFlightDetails(flightObj));
	}
	
	
	/*
	 * Testing 
	 */
	@Test
	public void testDeleteFlightDetails() {
		
		FlightDetails flightObj = new FlightDetails("pune", "delhi", 56, "25-12-2020", "26-12-2020", 
				"05:00", "23:55", "indianAirways", 9899.55);
		flightService.deleteFlight(flightObj.getFlightNumber());
		verify(repository, times(1)).deleteById(flightObj.getFlightNumber());
	}
}
