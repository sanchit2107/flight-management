package com.capgemini.flightmanagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.flightmanagement.dao.UserDao;
import com.capgemini.flightmanagement.entity.User;
import com.capgemini.flightmanagement.exception.NullUserException;
import com.capgemini.flightmanagement.exception.UserAlreadyExistException;
import com.capgemini.flightmanagement.exception.UserDoesnotExistException;
import com.capgemini.flightmanagement.service.UserService;
import com.capgemini.flightmanagement.utils.UserAuth;
import com.capgemini.flightmanagement.utils.UserJwtUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;
	
	@Autowired
	UserJwtUtil jwt;

	@Override
	public ResponseEntity<User> addUser(User user) {

		if (user == null)
			throw new NullUserException("No data recieved");
		Integer userId = (int) ((Math.random() * 900) + 100);
		user.setUserId(userId);
		Optional<User> checkUser = dao.findById(user.getUserId());
		if (checkUser.isPresent())
			throw new UserAlreadyExistException("user already exists");
		else {
			
			
			dao.save(user);
			UserAuth auth = new UserAuth(user.getUserId(), user.getPassword());
			String token = jwt.generateToken(auth);
			
			ResponseEntity<User> response = ResponseEntity.ok().header("token", token).body(user);
			
			System.out.println("user Added");
			return response;
		}
	}

	@Override
	public void updateUser(User user) {
		if (user == null)
			throw new NullUserException("No data recieved");
		Optional<User> checkUser = dao.findById(user.getUserId());
		if (checkUser.isPresent())
			dao.save(user);
		else
			throw new UserDoesnotExistException("User not found");

	}

	@Override
	public User getUser(Integer userId) {
		if (userId == null)
			throw new NullUserException("No data recieved");
		Optional<User> user = dao.findById(userId);
		if (!user.isPresent())
			throw new UserDoesnotExistException("User not found");
		return user.get();
	}

	@Override
	public void deleteUser(Integer userId) {
		if (userId == null)
			throw new NullUserException("No data recieved");
		Optional<User> user = dao.findById(userId);
		if (!user.isPresent())
			throw new UserDoesnotExistException("User not found");
		dao.deleteById(userId);
	}

	@Override
	public List<User> getAllUsers() {
		
		return dao.findAll();
	}

	@Override
	public ResponseEntity<User> userLogin(UserAuth auth) {
		if(auth == null) {
			throw new NullUserException("No data recieved");
		}
		Optional<User> user = dao.findById(auth.getUserId());
		if (user.isPresent()) {
			String token =  jwt.generateToken(auth);
			
			ResponseEntity<User> response = ResponseEntity.ok().header("token", token).body(user.get());
			return response;
		}
		else {
			throw new UserDoesnotExistException("User not found");
		}
	}

}
