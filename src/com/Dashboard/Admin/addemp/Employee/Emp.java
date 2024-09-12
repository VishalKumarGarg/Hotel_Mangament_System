package com.Dashboard.Admin.addemp.Employee;

public class Emp {
	private String name;
	private int age;
	private String gender;
	private String job;
	private double salary;
	private String phone;
	private String email;
	private String addhar;
	public Emp() {
		System.out.println("Default constructor is running....................");
	}
	public Emp(String name, int age, String gender, String job, double salary, String phone, String email,
			String addhar) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.job = job;
		this.salary = salary;
		this.phone = phone;
		this.email = email;
		this.addhar = addhar;
		System.out.println("Parameterized Constructor is Runninig..............");
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
	
	public String getJob() {
		return job;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getAddhar() {
		return addhar;
	}
	
	
	
}
