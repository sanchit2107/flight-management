package com.capgemini.flightmanagement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.flightmanagement.entity.User;
import com.capgemini.flightmanagement.exception.UserValidationException;
import com.capgemini.flightmanagement.serviceImpl.UserServiceImpl;
import com.capgemini.flightmanagement.utils.UserAuth;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl service;

	@PostMapping("/addUser")
	public ResponseEntity<String> add(@Valid @RequestBody User user, Errors error) {
		if (error.hasErrors()) {
			throw new UserValidationException("invalid data provided");
		}

		String token = service.addUser(user);
		return ResponseEntity.ok(token);
	}
	
	@PostMapping("/userLogin")
	public ResponseEntity<String> login(@RequestBody UserAuth auth) {
		String token = service.userLogin(auth);
		return ResponseEntity.ok(token);
	}

	@GetMapping("/getUser/{id}")
	public ResponseEntity<User> get(@PathVariable Integer id) {
		User user = service.getUser(id);
		return ResponseEntity.ok(user);
	}

	@PostMapping("/updateUser")
	public ResponseEntity<Void> update(@Valid @RequestBody User user) {
		service.updateUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
