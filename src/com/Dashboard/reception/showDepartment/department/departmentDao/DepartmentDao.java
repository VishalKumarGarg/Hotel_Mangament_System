package com.Dashboard.reception.showDepartment.department.departmentDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.Connection1.getConnnection;

public class DepartmentDao {
	Connection conn;
	Statement stmt;
	public ResultSet showAllDepartments() {
		try {
			String show="select * from department";
			conn=getConnnection.connection();
			stmt=conn.createStatement();
			return stmt.executeQuery(show);
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	} 
}
