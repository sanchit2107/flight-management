package com.capgemini.flightmanagement.entity;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Flight {
	
	@Id
	private BigInteger flightNumber;
	private String flightModel;
	private String carrierName;
	
	@OneToOne(mappedBy = "flight")
	private Schedule schedule;

	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Flight(BigInteger flightNumber, String flightModel, String carrierName, Schedule schedule) {
		super();
		this.flightNumber = flightNumber;
		this.flightModel = flightModel;
		this.carrierName = carrierName;
		this.schedule = schedule;
	}

	public BigInteger getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(BigInteger flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightModel() {
		return flightModel;
	}

	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
}
