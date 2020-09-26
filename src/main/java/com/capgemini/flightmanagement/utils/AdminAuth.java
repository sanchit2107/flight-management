package com.capgemini.flightmanagement.utils;

import org.springframework.stereotype.Component;

@Component
public class AdminAuth {

	private Integer adminId;
	private String password;

	public AdminAuth() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminAuth(Integer adminId, String password) {
		super();
		this.adminId = adminId;
		this.password = password;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
