package com.capgemini.flightmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.flightmanagement.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
