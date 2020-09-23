package com.capgemini.flightmanagement.entity;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Airport {
	@Id
	private BigInteger id;
	private String name;
	private String locaton;
	
	@OneToMany(mappedBy = "airport")
	private List<Schedule> schedules = new ArrayList<Schedule>();

	public Airport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Airport(BigInteger id, String name, String locaton, List<Schedule> schedules) {
		super();
		this.id = id;
		this.name = name;
		this.locaton = locaton;
		this.schedules = schedules;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocaton() {
		return locaton;
	}

	public void setLocaton(String locaton) {
		this.locaton = locaton;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}
	
}
