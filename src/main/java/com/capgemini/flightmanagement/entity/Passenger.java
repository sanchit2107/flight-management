package com.capgemini.flightmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 *  change the schema attribute according to your schema
 */

@Entity
@Table(name = "passengers",schema = "system")
public class Passenger {
	
	@Id
	private Integer passengerId;
	
	private String name;
	private Integer age;
	private Double luggage;
	
	@ManyToOne
	@JoinColumn(name = "booking_id")
	private BookingDetails bookingDetails;

	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passenger(Integer passengerId, String name, Integer age, Double luggage, BookingDetails bookingDetails) {
		super();
		this.passengerId = passengerId;
		this.name = name;
		this.age = age;
		this.luggage = luggage;
		this.bookingDetails = bookingDetails;
	}

	public Integer getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getLuggage() {
		return luggage;
	}

	public void setLuggage(Double luggage) {
		this.luggage = luggage;
	}

	public BookingDetails getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(BookingDetails bookingDetails) {
		this.bookingDetails = bookingDetails;
	}
	
	

}
