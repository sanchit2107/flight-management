package com.capgemini.flightmanagement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.flightmanagement.entity.User;
import com.capgemini.flightmanagement.serviceImpl.UserServiceImpl;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserServiceImpl service;
	
	@PostMapping("/addUser")
	public ResponseEntity<Void> add(@Valid @RequestBody User user)  {
		service.addUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<User> get(@PathVariable Integer id){
		System.out.println(id);
		User user = service.getUser(id);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/updateUser")
	public ResponseEntity<Void> update(@Valid @RequestBody User user){
		service.updateUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		service.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
