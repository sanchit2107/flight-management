package com.capgemini.flightmanagement.entity;

import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Passenger {
	
	@Id
	private BigInteger passengerUIN;
	private BigInteger pnrNumber;
	private String passengerName;
	private Integer passengerAge;
	private Double luggage;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "booking_id")
	private Booking booking;

	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passenger(BigInteger passengerUIN, BigInteger pnrNumber, String passengerName, Integer passengerAge,
			Double luggage, Booking booking) {
		super();
		this.passengerUIN = passengerUIN;
		this.pnrNumber = pnrNumber;
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		this.luggage = luggage;
		this.booking = booking;
	}

	public BigInteger getPassengerUIN() {
		return passengerUIN;
	}

	public void setPassengerUIN(BigInteger passengerUIN) {
		this.passengerUIN = passengerUIN;
	}

	public BigInteger getPnrNumber() {
		return pnrNumber;
	}

	public void setPnrNumber(BigInteger pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public Integer getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(Integer passengerAge) {
		this.passengerAge = passengerAge;
	}

	public Double getLuggage() {
		return luggage;
	}

	public void setLuggage(Double luggage) {
		this.luggage = luggage;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
}
