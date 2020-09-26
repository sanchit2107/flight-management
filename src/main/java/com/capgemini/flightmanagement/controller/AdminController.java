package com.capgemini.flightmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.flightmanagement.entity.Admin;
import com.capgemini.flightmanagement.serviceImpl.AdminServiceImpl;
import com.capgemini.flightmanagement.utils.AdminAuth;
import com.capgemini.flightmanagement.utils.AdminJwtUtil;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminServiceImpl service;
	
	@Autowired
	AdminJwtUtil jwt;
	
	@PostMapping("/addAdmin")
	public ResponseEntity<String> add(@RequestBody Admin admin){
		String token = service.addAdmin(admin);
		return ResponseEntity.ok(token);
	}
	
	@PostMapping("/adminLogin")
	public ResponseEntity<String> login(@RequestBody AdminAuth auth){
		String token = service.adminLogin(auth);
		return ResponseEntity.ok(token);
	}
	
	@GetMapping("/getAdmin/{id}")
	public ResponseEntity<Admin> get(@PathVariable Integer id){
		Admin admin = service.getAdmin(id);
		return ResponseEntity.ok(admin);
	}
	
	@DeleteMapping("/deleteAdmin/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.deleteAdmin(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
		
}
