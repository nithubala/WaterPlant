package com.revature.waterplant.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.waterplant.Model.User;
import com.revature.waterplant.Util.ConnectionUtil;

public class ReserveDAO {

	public static void addReserve(User user, int reservedCans) {
		
		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into reservedetails(User_id,User_name,Mobile_no,Reserved_cans,Reserved_status) values"
				+ "(?,?,?,?,?) ";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, user.getId());
			pst.setString(2, user.getName());
			pst.setLong(3, user.getMobileNo());
			pst.setInt(4,reservedCans);
			pst.setString(5,"Order Pending");
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to reserve");
		}
		
		
	}

	public static User findById(int id) {
		
		Connection con = ConnectionUtil.getConnection();
		String sql = "select * from reservedetails where User_id=? and Reserved_status='Order Pending' ";
		PreparedStatement pst;
		User user=null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,id);
			ResultSet rs = pst.executeQuery();
		
			if(rs.next()) {
			    user = new User();
				user.setId(rs.getInt("Reserve_id"));
				user.setName(rs.getString("User_name"));
				user.setMobileNo(rs.getLong("Mobile_no"));
				user.setNoOfCans(rs.getInt("Reserved_cans"));
			
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return user;
	}

	public static void updateReserve(User user, int reservedCans) {
		
		Connection con = ConnectionUtil.getConnection();
		String sql = "update reservedetails set Reserved_cans = ? where User_id= ?";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,reservedCans);
			pst.setInt(2, user.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	public static User findByReserveId(int id) {
		Connection con = ConnectionUtil.getConnection();
		String sql = "select * from reservedetails where Reserve_id= ? and Reserved_status='Order Pending'";
		PreparedStatement pst;
		User user=null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,id);
			ResultSet rs = pst.executeQuery();
		
			if(rs.next()) {
			    user = new User();
				user.setId(rs.getInt("User_id"));
				user.setReserveId(rs.getInt("Reserve_id"));
				user.setName(rs.getString("User_name"));
				user.setMobileNo(rs.getLong("Mobile_no"));
				user.setNoOfCans(rs.getInt("Reserved_cans"));
				user.setReserveStatus(rs.getString("Reserved_status"));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return user;
	}

public static void updateStatus(User u) {
		
		Connection con = ConnectionUtil.getConnection();
		String sql = "update reservedetails set Reserved_status ='Ordered' where Reserve_id= ?";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,u.getReserveId());
			pst.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	
	
}
