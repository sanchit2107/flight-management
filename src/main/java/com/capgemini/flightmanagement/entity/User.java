package com.capgemini.flightmanagement.entity;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	private BigInteger id;
	private String userName;
	private String password;
	private BigInteger phone;
	private String email;
	
	@OneToMany(mappedBy = "user")
	private List<Booking> bookings = new ArrayList<Booking>();

	public User(BigInteger id, String userName, String password, BigInteger phone, String email,
			List<Booking> bookings) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.bookings = bookings;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigInteger getPhone() {
		return phone;
	}

	public void setPhone(BigInteger phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	
	
}
