package com.Dashboard.reception.addCustomer.customer.customerDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Connection1.getConnnection;
import com.Dashboard.reception.addCustomer.customer.Customer;

public class CustomerDao {
	Connection conn;
	Statement stmt;
	public int save(Customer c) {
		String save="insert into Customers values('"+c.getCusId()+"','"+c.getCusIdNo()+"','"+c.getCusName()+"','"+c.getCusGender()+"','"+c.getCusCountry()+"',"+c.getCusRoom()+",'"+c.getCusCheckingTime()+"',"+c.getCusDeposit()+");";
		String update="update rooms set roomAvailablity='Occupied' where roomNo="+c.getCusRoom();
		int done=0;
		try {
			conn= getConnnection.connection();
			stmt=conn.createStatement();
			done=stmt.executeUpdate(save);
			stmt.executeUpdate(update);
			conn.close();
			return done;
		} catch (SQLException e) {
			e.printStackTrace();
			return done;
		}
	}
	
	public ResultSet showAllCustomer() {
		try {
			String show="select * from Customers";
			conn=getConnnection.connection();
			stmt=conn.createStatement();
			return stmt.executeQuery(show);
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet showOneCustomer(String str) {
		try {
			String show="select * from Customers where CustomerIdNo='"+str+"'";
			conn=getConnnection.connection();
			stmt=conn.createStatement();
			return stmt.executeQuery(show);
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public void deleteCustomer(String id) {
		String str1= "delete from Customers where CustomerIdNo='"+id+"'";
		try {
			conn=getConnnection.connection();
			stmt=conn.createStatement();
			 stmt.executeUpdate(str1);
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
