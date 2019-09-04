package com.revature.waterplant.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.revature.waterplant.Model.User;
import com.revature.waterplant.Util.ConnectionUtil;

public class UserDAO {

	public static void register(User user) {
		
		
			Connection con=ConnectionUtil.getConnection();
			String sql="insert into userdetails (User_name,Email_id,Password,Address,Mobile_no) values( ?,?,?,?,?)";
			PreparedStatement pst;
			try {
				pst = con.prepareStatement(sql);
				pst.setString(1,user.getName());
				pst.setString(2, user.getEmailId());
				pst.setString(3, user.getPassword());
				pst.setString(4, user.getAddress());
				pst.setLong(5, user.getMobileNo());
				
				pst.executeUpdate();
			} catch (SQLException e) {
				
				e.printStackTrace();
				throw new RuntimeException("Unable to register");
			}
			
	}
	
	public static boolean login(String emailId, String password) {

		Connection con = ConnectionUtil.getConnection();
		String sql = "select * from userdetails where Email_id=? and Password=?";
		boolean isValid = false;
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, emailId);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				isValid = true;
			} else {
				isValid = false;
			}

		} catch (SQLException e) {
			throw new RuntimeException("Unable to login");
		}
		return isValid;

	}
	
	public static User getUserID(String emailId) {

		Connection con = ConnectionUtil.getConnection();
		String sql = "select * from userdetails where Email_id=?";
		PreparedStatement pst;
		int id = 0;
		User user=null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, emailId);
			ResultSet rs = pst.executeQuery();
            if (rs.next()) {
				
				user = new User();
				user.setId(rs.getInt("User_id"));
				user.setName(rs.getString("User_name"));
				user.setEmailId(rs.getString("Email_id"));
				user.setPassword(rs.getString("Password"));
				user.setAddress(rs.getString("Address"));
				user.setMobileNo(rs.getLong("Mobile_no"));
				
				}
         } catch (SQLException e) {

			e.printStackTrace();
		}
        return user;

	}
	
	

}
