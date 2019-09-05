package com.revature.waterplant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.waterplant.exception.DBException;
import com.revature.waterplant.model.User;
import com.revature.waterplant.util.ConnectionUtil;

public class OrderDAO implements OrderDAOImp {

	public void addOrder(User u, int noOfCans) throws DBException {
		
		Connection con =null;
		PreparedStatement pst = null;
		con = ConnectionUtil.getConnection();
		String sql = "insert into orderdetails(User_id,User_name,Mobile_no,Address,Ordered_cans) values"
				+ "(?,?,?,?,?) ";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, u.getId());
			pst.setString(2, u.getName());
			pst.setLong(3, u.getMobileNo());
			pst.setString(4, u.getAddress());
			pst.setInt(5,noOfCans);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to order Cans", e);
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
		
}

	public  void addReserveOrder(User u,int orderedCans, String Address) throws DBException {
		
		Connection con =null;
		PreparedStatement pst = null;
		con = ConnectionUtil.getConnection();
		String sql = "insert into orderdetails(User_id,Reserve_id,User_name,Mobile_no,Address,Ordered_cans) values"
				+ "(?,?,?,?,?,?) ";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, u.getId());
			pst.setInt(2, u.getReserveId());
			pst.setString(3,u.getName());
			pst.setLong(4,u.getMobileNo());
			pst.setString(5, Address);
			pst.setInt(6,orderedCans);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to order Reserved Cans",e);
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
	}
	


}
