package com.capgemini.flightmanagement.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 *  change the schema attribute according to your schema
 */

@Entity
@Table(name = "booking_details",schema = "bootcampuser")
public class BookingDetails {

	@Id
	private Integer bookingId;
	
	private String bookingDate;
	
	private String bookingTime;
	
	private Double totalCost;
	
	private Integer flightNumber;
	
	
	private Integer ownerId;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Passenger> passengers = new ArrayList<Passenger>();

	public BookingDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public BookingDetails(Integer bookingId, String bookingDate, String bookingTime, Double totalCost,
			Integer flightNumber, Integer ownerId) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.bookingTime = bookingTime;
		this.totalCost = totalCost;
		this.flightNumber = flightNumber;
		this.ownerId = ownerId;
	}



	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	

	public String getBookingDate() {
		return bookingDate;
	}



	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}



	public String getBookingTime() {
		return bookingTime;
	}



	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public Integer getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(Integer flightNumber) {
		this.flightNumber = flightNumber;
	}
	

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	
}
