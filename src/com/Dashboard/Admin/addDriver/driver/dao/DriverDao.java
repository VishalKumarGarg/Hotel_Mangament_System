package com.Dashboard.Admin.addDriver.driver.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Connection1.getConnnection;
import com.Dashboard.Admin.addDriver.driver.Driver;

public class DriverDao {
	public int save(Driver d) {
		String save="insert into Drivers values('"+d.getName()+"',"+d.getAge()+",'"+d.getGender()+"','"+d.getCarCompany()+"','"+d.getCarModel()+"','"+d.getAvailable()+"','"+d.getLocation()+"')";
		int done=0;
		try {
			Connection conn = getConnnection.connection();
			Statement stmt = conn.createStatement();
			done=stmt.executeUpdate(save);
			conn.close();
			return done;
		} catch (SQLException e) {
			e.printStackTrace();
			return done;
		}
	}
	public ResultSet shwoDrivers() {
		try {
			Connection conn;
			Statement stmt;
			String save="select * from Drivers";conn=getConnnection.connection();
			stmt=conn.createStatement();
			return stmt.executeQuery(save);
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}