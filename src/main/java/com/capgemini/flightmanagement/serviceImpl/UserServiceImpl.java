package com.capgemini.flightmanagement.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.flightmanagement.dao.UserDao;
import com.capgemini.flightmanagement.entity.User;
import com.capgemini.flightmanagement.service.UserService;
import com.capgemini.flightmanagement.userException.NullUserException;
import com.capgemini.flightmanagement.userException.UserAlreadyExistException;
import com.capgemini.flightmanagement.userException.UserDoesnotExistException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;

	@Override
	public void addUser(User user) {

		if (user == null)
			throw new NullUserException("No data recieved");
		Optional<User> checkUser = dao.findById(user.getUserId());
		if (checkUser.isPresent())
			throw new UserAlreadyExistException("user already exists");
		else
			dao.save(user);
		System.out.println("user Added");
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
//		User user = dao.getOne(userId);
		if (!user.isPresent())
			throw new UserDoesnotExistException("User not found");
		return user.get();
	}

	@Override
	public void deleteUser(Integer userId) {
		if (userId == null)
			throw new NullUserException("No data recieved");
		User user = dao.getOne(userId);
		if (user == null)
			throw new UserDoesnotExistException("User not found");
		dao.deleteById(userId);

	}

}
