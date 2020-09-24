package com.capgemini.flightmanagement.service;

import org.springframework.stereotype.Service;

import com.capgemini.flightmanagement.entity.User;

@Service
public interface UserService {
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public User getUser(Integer userId);
	
	public void deleteUser(Integer userId);
}
