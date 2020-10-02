package com.capgemini.flightmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/*
 *  change the schema attribute according to your schema
 */

@Entity
@Table(name = "flight_details", schema = "hr")
public class FlightDetails {

	@Id
	private Integer flightNumber;

	@NotNull(message = "Departure Airport cannot be null")
	private String departureAirport;

	@NotNull(message = "Source Airport cannot be null")
	private String arrivalAirport;

	private Integer availableSeats;

	@NotNull(message = "daparture date cannot be null")
	private String departureDate;

	@NotNull(message = "arrival date cannot b null")
	private String arrivalDate;

	@NotNull(message = "Arival Time cannot be null")
	private String arrivalTime;

	@NotNull(message = "Departure Time cannot be null")
	private String departureTime;

	@NotNull(message = "Flight Vendor cannot be null")
	private String flightVendor;

	@NotNull(message = "cost cannot be null")
	private Double cost;

	public FlightDetails() {
		super();
	}

	public FlightDetails(
			@NotNull(message = "Departure Airport cannot be null") String departureAirport,
			@NotNull(message = "Source Airport cannot be null") String arrivalAirport, Integer availableSeats,
			@NotNull(message = "daparture date cannot be null") String departureDate,
			@NotNull(message = "arrival date cannot b null") String arrivalDate,
			@NotNull(message = "Arival Time cannot be null") String arrivalTime,
			@NotNull(message = "Departure Time cannot be null") String departureTime,
			@NotNull(message = "Flight Vendor cannot be null") String flightVendor, Double cost) {
		super();
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
		this.availableSeats = availableSeats;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.flightVendor = flightVendor;
		this.cost = cost;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
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
		this.departureAirport = departureAirport.toLowerCase();
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport.toLowerCase();
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	public String getFlightVendor() {
		return flightVendor;
	}

	public void setFlightVendor(String flightVendor) {
		this.flightVendor = flightVendor;
	}

}
