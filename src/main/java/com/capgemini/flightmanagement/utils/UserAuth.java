
package com.capgemini.flightmanagement.utils;

import org.springframework.stereotype.Component;

@Component
public class UserAuth {

	private Integer userId;
	private String password;

	public UserAuth() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAuth(Integer userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
