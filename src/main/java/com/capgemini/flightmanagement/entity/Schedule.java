package com.capgemini.flightmanagement.entity;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Schedule {
	
	private BigInteger id;
	private Integer vacancy;
	private LocalDateTime arrivalTime;
	private LocalDateTime departureTime;	
	private Airport dapartureAirport;
	private Airport arrivalAirport;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "flight_id")
	private Flight flight;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "airport_id")
	private Airport airport;
	
	@OneToMany(mappedBy = "schedule")
	private List<Booking> bookings = new ArrayList<Booking>();
	
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Integer getVacancy() {
		return vacancy;
	}

	public void setVacancy(Integer vacancy) {
		this.vacancy = vacancy;
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

	public Airport getDapartureAirport() {
		return dapartureAirport;
	}

	public void setDapartureAirport(Airport dapartureAirport) {
		this.dapartureAirport = dapartureAirport;
	}

	public Airport getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Airport getAirport() {
		return airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Schedule(BigInteger id, Integer vacancy, LocalDateTime arrivalTime, LocalDateTime departureTime,
			Airport dapartureAirport, Airport arrivalAirport, Flight flight, Airport airport, List<Booking> bookings) {
		super();
		this.id = id;
		this.vacancy = vacancy;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.dapartureAirport = dapartureAirport;
		this.arrivalAirport = arrivalAirport;
		this.flight = flight;
		this.airport = airport;
		this.bookings = bookings;
	}

	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
