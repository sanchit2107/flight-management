package com.capgemini.flightmanagement.entity;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Booking {
	
	@Id
	private BigInteger bookingId;
	private LocalDateTime bookingDateTime;
	private Double cost;
	private Integer numberOfPassengers;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "schedule_id")
	private Schedule schedule;
	
	@OneToMany(mappedBy = "booking")
	private List<Passenger> passengers = new ArrayList<Passenger>();

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(BigInteger bookingId, LocalDateTime bookingDateTime, Double cost, Integer numberOfPassengers,
			User user, Schedule schedule, List<Passenger> passengers) {
		super();
		this.bookingId = bookingId;
		this.bookingDateTime = bookingDateTime;
		this.cost = cost;
		this.numberOfPassengers = numberOfPassengers;
		this.user = user;
		this.schedule = schedule;
		this.passengers = passengers;
	}

	public BigInteger getBookingId() {
		return bookingId;
	}

	public void setBookingId(BigInteger bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDateTime getBookingDateTime() {
		return bookingDateTime;
	}

	public void setBookingDateTime(LocalDateTime bookingDateTime) {
		this.bookingDateTime = bookingDateTime;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Integer getNumberOfPassengers() {
		return numberOfPassengers;
	}

	public void setNumberOfPassengers(Integer numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	
}
