package com.Connection1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class getConnnection {
	final static String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
    final static String DB_URL="jdbc:mysql://localhost:3306/hotel_management_system2?useSSL=false";
    final static String DB_User="root";
    final static String DB_Password="vishal123";
    public static Connection connection() {
			try {
				Class.forName(JDBC_DRIVER);
				Connection conn=DriverManager.getConnection(DB_URL,DB_User,DB_Password);
				return conn;
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, e);
				e.printStackTrace();
				return null;
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e);
				e.printStackTrace();
				return null;
			}
			
		
		
    }
}
