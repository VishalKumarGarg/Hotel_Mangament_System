package com.Dashboard.Admin.addRooms.room.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Connection1.getConnnection;
import com.Dashboard.Admin.addRooms.room.Room;

public class RoomDao {
	Connection conn;
	Statement stmt;
	public int saveRoom(Room r) {
		String save="insert into Rooms values("+r.getRoomNo()+",'"+r.getRoomAvailable()+"','"+r.getRoomStatus()+"',"+r.getRoomPrice()+",'"+r.getRoomBedType()+"')";
		int done=0;
		try {
			conn= getConnnection.connection();
			stmt=conn.createStatement();
			done=stmt.executeUpdate(save);
			conn.close();
			return done;
		} catch (SQLException e) {
			e.printStackTrace();
			return done;
		}
	}
	public ResultSet showRooms() {
		try {
			String show="select * from rooms where roomAvailablity='Available' and roomStatus='Clean'";
			conn=getConnnection.connection();
			stmt=conn.createStatement();
			return stmt.executeQuery(show);
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet allShowRooms() {
		try {
			String show="select * from rooms";
			conn=getConnnection.connection();
			stmt=conn.createStatement();
			return stmt.executeQuery(show);
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet searchRoom1(String str1) {
		try {
			conn=getConnnection.connection();
			stmt=conn.createStatement();
			return stmt.executeQuery(str1);
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet searchRoomId(double id) {
		try {
			String str1="select * from Rooms where roomNo="+id;
			conn=getConnnection.connection();
			stmt=conn.createStatement();
			return stmt.executeQuery(str1);
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public void update1room(int id) {
		String str1="update rooms set roomAvailablity='Available' where roomNo="+id;
		try {
			conn=getConnnection.connection();
			stmt=conn.createStatement();
			stmt.executeUpdate(str1);
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
