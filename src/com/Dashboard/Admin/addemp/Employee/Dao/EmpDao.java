package com.Dashboard.Admin.addemp.Employee.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Connection1.getConnnection;
import com.Dashboard.Admin.addemp.Employee.Emp;

public class EmpDao {
	Connection conn;
	Statement stmt;
	public int save(Emp emp1) {
		String save ="insert into EmpDetails values('"+emp1.getName()+"',"+emp1.getAge()+",'"+emp1.getGender()+"','"+emp1.getJob()+"',"+emp1.getSalary()+",'"+emp1.getPhone()+"','"+emp1.getEmail()+"','"+emp1.getAddhar()+"')";
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
	
	public ResultSet allShowEmployee() {
		try {
			String show="select * from EmpDetails";
			conn=getConnnection.connection();
			stmt=conn.createStatement();
			return stmt.executeQuery(show);
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet allShowManager() {
		try {
			String show="select * from EmpDetails where job='Manager'";
			conn=getConnnection.connection();
			stmt=conn.createStatement();
			return stmt.executeQuery(show);
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
