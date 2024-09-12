package com.Dashboard.reception.showDepartment.department;

public class Department {
	String departments;
	double budget;
	public Department(String departments, double budget) {
		super();
		this.departments = departments;
		this.budget = budget;
	}
	public String getDepartments() {
		return departments;
	}
	public double getBudget() {
		return budget;
	}
	
}
