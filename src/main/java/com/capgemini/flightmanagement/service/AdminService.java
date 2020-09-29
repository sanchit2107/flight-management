package com.capgemini.flightmanagement.service;

import java.util.List;

import com.capgemini.flightmanagement.entity.Admin;
import com.capgemini.flightmanagement.entity.FlightDetails;
import com.capgemini.flightmanagement.utils.AdminAuth;

public interface AdminService {
	public Admin addAdmin(Admin admin);

	public Admin getAdmin(Integer adminId);

	public void deleteAdmin(Integer adminId);

	public Admin adminLogin(AdminAuth auth);

	public List<FlightDetails> getAllFlightDetails();

	public FlightDetails addFlightDetails(FlightDetails details);

	public void deleteFlight(Integer flightNumber);

	public FlightDetails updateFlight(FlightDetails details);

}
