package com.capgemini.flightmanagement.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.flightmanagement.entity.User;
import com.capgemini.flightmanagement.utils.UserAuth;

@Service
public interface UserService {
	
	public ResponseEntity<User> addUser(User user);
	
	public void updateUser(User user);
	
	public User getUser(Integer userId);
	
	public void deleteUser(Integer userId);
	
	public List<User> getAllUsers();
	
	public ResponseEntity<User> userLogin(UserAuth auth);
}
