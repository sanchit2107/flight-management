package com.capgemini.flightmanagement.service;


import org.springframework.stereotype.Service;

import com.capgemini.flightmanagement.entity.Admin;
import com.capgemini.flightmanagement.utils.AdminAuth;


@Service
public interface AdminService {

	public String addAdmin(Admin admin);

	public Admin getAdmin(Integer adminId);

	public void deleteAdmin(Integer adminId);

	public String adminLogin(AdminAuth auth);

}
