package com.revature.waterplant.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionUtil {
	
	public static Connection getConnection() {
		String driverClassName = "com.mysql.jdbc.Driver";
		String	url ="jdbc:mysql://localhost:3306/waterplantdb";
		String username = "root";
		String password = "root";
		
		Connection con = null;

		try {
			Class.forName(driverClassName);
			con = DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	
		return con;
	}

	public static void close(Connection con, PreparedStatement pst) {

		try {
			if (pst != null) pst.close();
			if (con != null) con.close();
		}
		catch(Exception e) {
			
		}
		
		
	}
}
