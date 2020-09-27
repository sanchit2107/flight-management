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
@Table(name = "booking_details",schema = "hr")
public class BookingDetails {

	@Id
	private Integer bookingId;
	private LocalDateTime bookingTime;
	private Double totalCost;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "flightdetails_id")
	private FlightDetails flightDetails;
	
	
	private Integer ownerId;
	
	@OneToMany(mappedBy = "bookingDetails",cascade = CascadeType.ALL)
	private List<Passenger> passengers = new ArrayList<Passenger>();

	public BookingDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingDetails(Integer bookingId, LocalDateTime bookingTime, Double totalCost, FlightDetails flightDetails,
			Integer ownerId) {
		super();
		this.bookingId = bookingId;
		this.bookingTime = bookingTime;
		this.totalCost = totalCost;
		this.flightDetails = flightDetails;
		this.ownerId = ownerId;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDateTime getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(LocalDateTime bookingTime) {
		this.bookingTime = bookingTime;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public FlightDetails getFlightDetails() {
		return flightDetails;
	}

	public void setFlightDetails(FlightDetails flightDetails) {
		this.flightDetails = flightDetails;
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
