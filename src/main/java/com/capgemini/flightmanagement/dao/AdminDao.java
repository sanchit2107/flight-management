package com.capgemini.flightmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.flightmanagement.entity.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer> {

}
