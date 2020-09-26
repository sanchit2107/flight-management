package com.capgemini.flightmanagement;



import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.flightmanagement.entity.User;
import com.capgemini.flightmanagement.serviceImpl.UserServiceImpl;
import com.capgemini.flightmanagement.utils.UserAuth;
import com.capgemini.flightmanagement.utils.UserJwtUtil;

@SpringBootApplication
public class FlightManagementApplication   {
	
	@Autowired
	UserJwtUtil jwt;
	
//	@PostConstruct
//	public void initUsers() {
//		UserAuth u = new UserAuth(345, "abc");
//		String token = jwt.generateToken(u);
//		System.out.println("user token = " + token);
//		
//		System.out.println("user id = " + jwt.extractUserId(token));
//		
//		if (jwt.validateToken(token, u)) {
//			System.out.println("validated");
//		} else {
//			System.out.println("invalid");
//		}
//	}
		
	public static void main(String[] args) {
		SpringApplication.run(FlightManagementApplication.class, args);
	}


}
