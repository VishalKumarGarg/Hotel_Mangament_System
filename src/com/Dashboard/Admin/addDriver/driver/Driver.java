package com.Dashboard.Admin.addDriver.driver;

public class Driver {
	private String name;
	private int age;
	private String gender;
	private String carCompany;
	private String carModel;
	private String available;
	private String location;
	public Driver(String name, int age, String gender, String carCompany, String carModel, String available,
			String location) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.carCompany = carCompany;
		this.carModel = carModel;
		this.available = available;
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
	public String getCarCompany() {
		return carCompany;
	}
	public String getCarModel() {
		return carModel;
	}
	public String getAvailable() {
		return available;
	}
	public String getLocation() {
		return location;
	}
	
	
}
