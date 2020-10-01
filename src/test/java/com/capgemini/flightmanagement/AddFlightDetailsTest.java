package com.capgemini.flightmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

@SpringBootTest
public class AddFlightDetailsTest {

	
	@Autowired
	private AdminService flightService;
	
	@MockBean
	private FlightDetailsDao repository;
	
	@Test
	public void testGetFlightDetails() {
		when(repository.findAll()).thenReturn(Stream
				.of(new FlightDetails("delhi", "mumabi", 25, "01-11-2020", "01-11-2020", 
						"23:00", "17:00", "indoGo", 7899.00)).collect(Collectors.toList()));
		assertEquals(1, flightService.getAllFlightDetails().size());
	}
	
	@Test
	public void testDisplayAllFlightDetails() {
		when(repository.findAll()).thenReturn(Stream
				.of(new FlightDetails("delhi", "mumabi", 25, "01-11-2020", "01-22-2020", "23:00", 
						"17:00", "indoGo", 7899.00), 
						new FlightDetails("bangalore", "kolkatta", 48, "02-12-2020", "03-12-2020", 
								"05:20", "23:05", "spiceJet", 12899.00)).collect(Collectors.toList()));
		assertEquals(2, flightService.getAllFlightDetails().size());
	}
}
