package com.capgemini.flightmanagement.utils;

import org.springframework.stereotype.Component;

@Component
public class UserAuth {

	private int userId;
	private String password;

	

	public UserAuth(int userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public UserAuth() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
