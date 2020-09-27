package com.capgemini.flightmanagement.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.flightmanagement.dao.AdminDao;
import com.capgemini.flightmanagement.entity.Admin;
import com.capgemini.flightmanagement.exception.AdminAlreadyExistException;
import com.capgemini.flightmanagement.exception.AdminDoesnotExistException;
import com.capgemini.flightmanagement.exception.NullAdminException;
import com.capgemini.flightmanagement.service.AdminService;
import com.capgemini.flightmanagement.utils.AdminAuth;
import com.capgemini.flightmanagement.utils.AdminJwtUtil;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao dao;

	@Autowired
	AdminJwtUtil jwt;

	@Override
	public String addAdmin(Admin admin) {
		if (admin == null)
			throw new NullAdminException("no data provided");
//		Integer adminId = (int) ((Math.random() * 900) + 100);
//		admin.setAdminId(adminId);
		Optional<Admin> checkAdmin = dao.findById(admin.getAdminId());
		if (checkAdmin.isPresent()) {
			throw new AdminAlreadyExistException("admin already exist exception");
		} else {
			dao.save(admin);
			AdminAuth auth = new AdminAuth(admin.getAdminId(), admin.getPassword());
			String token = jwt.generateToken(auth);
			return token;
		}
	}

	@Override
	public Admin getAdmin(Integer adminId) {
		if (adminId == null)
			throw new NullAdminException("no data provided");
		Optional<Admin> admin = dao.findById(adminId);
		if (!admin.isPresent()) {
			throw new AdminDoesnotExistException("admin does not exist ");
		}
		return admin.get();
	}

	@Override
	public void deleteAdmin(Integer adminId) {
		if (adminId == null)
			throw new NullAdminException("no data provided");
		Optional<Admin> admin = dao.findById(adminId);
		if (!admin.isPresent()) {
			throw new AdminDoesnotExistException("admin Doesnot Exist Exception");
		}
		dao.deleteById(adminId);
	}

	@Override
	public String adminLogin(AdminAuth auth) {
		if (auth == null) {
			throw new NullAdminException("no data provided");
		}
		Optional<Admin> admin = dao.findById(auth.getAdminId());
		if (admin.isPresent()) {
			return jwt.generateToken(auth);
		}
		else throw new AdminDoesnotExistException("admin doesnot exist");
	}

}
