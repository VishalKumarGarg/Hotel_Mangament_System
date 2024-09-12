package com.Dashboard.Admin.addRooms.room;

public class Room {
	int roomNo;
	String roomAvailable;
	String roomStatus;
	double roomPrice;
	String roomBedType;
	
	public Room() {
		System.out.println("Default Constructor is Running.......");
	}

	public int getRoomNo() {
		return roomNo;
	}

	public String getRoomAvailable() {
		return roomAvailable;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public double getRoomPrice() {
		return roomPrice;
	}

	public String getRoomBedType() {
		return roomBedType;
	}


	public Room(int roomNo, String roomAvailable, String roomStatus, double roomPrice, String roomBedType) {
		System.out.println("Parameterized Constructor is running......");
		this.roomNo = roomNo;
		this.roomAvailable = roomAvailable;
		this.roomStatus = roomStatus;
		this.roomPrice = roomPrice;
		this.roomBedType = roomBedType;
	}
}
