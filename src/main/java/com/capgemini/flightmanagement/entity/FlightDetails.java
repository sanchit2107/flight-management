package com.capgemini.flightmanagement.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FlightDetails {

	@Id
	private Integer flightNumber;
	private String departureAirport;
	private String arrivalAirport;
	private Integer availableSeats;
	private LocalDateTime arrivalTime;
	private LocalDateTime departureTime;
	private String flightVendor;
	private Double cost;

	public FlightDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlightDetails(Integer flightNumber, String departureAirport, String arrivalAirport, Integer availableSeats,
			LocalDateTime arrivalTime, LocalDateTime departureTime, String flightVendor,Double cost) {
		super();
		this.flightNumber = flightNumber;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
		this.availableSeats = availableSeats;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.flightVendor = flightVendor;
		this.cost = cost;
	}
	
	

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Integer getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(Integer flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public String getFlightVendor() {
		return flightVendor;
	}

	public void setFlightVendor(String flightVendor) {
		this.flightVendor = flightVendor;
	}

}
