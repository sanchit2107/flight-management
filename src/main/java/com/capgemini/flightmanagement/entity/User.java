package com.capgemini.flightmanagement.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


/*
 *  change the schema attribute according to your schema
 */

@Entity
@Table(name = "users",schema = "hr")
public class User {
	
	@Id
	private Integer userId;
	@NotNull(message = "username cannot be null")
	private String userName;
	@NotNull(message = "password cannot be null")
	@Min(value = 8,message = "password cannot be smaller than 8 characters")
	private String password;
	@NotNull(message = "phone cannot be null")
	private Long phone;
	@NotNull(message = "email cannot be null")
	private String email;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<BookingDetails> bookingDetails = new ArrayList<BookingDetails>();

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer userId, String userName, String password, Long phone, String email) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.email = email;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<BookingDetails> getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(List<BookingDetails> bookingDetails) {
		this.bookingDetails = bookingDetails;
	}
	

}
