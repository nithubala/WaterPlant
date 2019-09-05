package com.revature.waterplant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.waterplant.exception.DBException;
import com.revature.waterplant.model.User;
import com.revature.waterplant.util.ConnectionUtil;

public class ReserveDAO implements ReserveDAOImp{

	public  void addReserve(User user, int reservedCans) throws DBException {
		
		Connection con =null;
		PreparedStatement pst = null;
		con= ConnectionUtil.getConnection();
		String sql = "insert into reservedetails(User_id,User_name,Mobile_no,Reserved_cans,Reserved_status) values"
				+ "(?,?,?,?,?) ";
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
			throw new DBException("Unable to reserve",e);
		}
		
		finally {
			ConnectionUtil.close(con, pst);
		}
	}

	public User findById(int id) {
		
		Connection con =null;
		PreparedStatement pst = null;
	    con = ConnectionUtil.getConnection();
		String sql = "select * from reservedetails where User_id=? and Reserved_status='Order Pending' ";
		User user=null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,id);
			ResultSet rs = pst.executeQuery();
		
			if(rs.next()) {
			    user = new User();
				user.setReserveId(rs.getInt("Reserve_id"));
				user.setName(rs.getString("User_name"));
				user.setMobileNo(rs.getLong("Mobile_no"));
				user.setNoOfCans(rs.getInt("Reserved_cans"));
			
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
		
		return user;
	}

	public  void updateReserve(User u, int reservedCans) throws DBException {
		
		Connection con =null;
		PreparedStatement pst = null;
		con = ConnectionUtil.getConnection();
		String sql = "update reservedetails set Reserved_cans = ? where Reserve_id= ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,reservedCans);
			pst.setInt(2, u.getReserveId());
			pst.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new DBException("Unable to reserve",e);
		}
		
		finally {
			ConnectionUtil.close(con, pst);
		}
	}

	public  User findByReserveId(int id) {
		
		Connection con =null;
		PreparedStatement pst = null;
		con = ConnectionUtil.getConnection();
		String sql = "select * from reservedetails where Reserve_id= ? and Reserved_status='Order Pending'";
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
		finally {
			ConnectionUtil.close(con, pst);
		}
		
		return user;
	}

public  void updateStatus(User u,int orderedCans) {
	
	    Connection con =null;
	    PreparedStatement pst = null;
		con = ConnectionUtil.getConnection();
		String sql = "update reservedetails set Reserved_status ='Ordered',Ordered_cans=? where Reserve_id= ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,orderedCans);
			pst.setInt(2,u.getReserveId());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		finally {
			ConnectionUtil.close(con, pst);
		}
	}

	
	
}
