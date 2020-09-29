package com.capgemini.flightmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.flightmanagement.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

}
