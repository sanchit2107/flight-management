package com.capgemini.flightmanagement;



import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.flightmanagement.entity.User;
import com.capgemini.flightmanagement.serviceImpl.UserServiceImpl;

@SpringBootApplication
public class FlightManagementApplication {
	
	@Autowired
	UserServiceImpl service;
	
//	@PostConstruct
//	public void initUsers() {
//		User u = new User(123, "tarun", "baguvixt", 4678l, "asdf");
//		service.addUser(u);
//	}
		
	public static void main(String[] args) {
		SpringApplication.run(FlightManagementApplication.class, args);
	}

}
