package com.Dashboard.reception.addCustomer.customer;

public class Customer {
	String cusId;
	String cusIdNo;
	String cusName;
	String cusGender;
	String cusCountry;
	int cusRoom;
	String cusCheckingTime;
	double cusDeposit;
	
	public Customer(String cusId, String cusIdNo, String cusName, String cusGender, String cusCountry, int cusRoom,
			String cusCheckingTime, double cusDeposit) {
		this.cusId = cusId;
		this.cusIdNo = cusIdNo;
		this.cusName = cusName;
		this.cusGender = cusGender;
		this.cusCountry = cusCountry;
		this.cusRoom = cusRoom;
		this.cusCheckingTime = cusCheckingTime;
		this.cusDeposit = cusDeposit;
	}
	public String getCusId() {
		return cusId;
	}
	public String getCusIdNo() {
		return cusIdNo;
	}
	public String getCusName() {
		return cusName;
	}
	public String getCusGender() {
		return cusGender;
	}
	public String getCusCountry() {
		return cusCountry;
	}
	public int getCusRoom() {
		return cusRoom;
	}
	public String getCusCheckingTime() {
		return cusCheckingTime;
	}
	public double getCusDeposit() {
		return cusDeposit;
	}

}
