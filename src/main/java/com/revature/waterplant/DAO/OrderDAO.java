package com.revature.waterplant.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.waterplant.Model.User;
import com.revature.waterplant.Util.ConnectionUtil;

public class OrderDAO {

	public static void addOrder(User u, int noOfCans) {
	
		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into orderdetails(User_id,User_name,Mobile_no,Address,Ordered_cans) values"
				+ "(?,?,?,?,?) ";
		PreparedStatement pst;
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
			throw new RuntimeException("Unable to order");
		}
		
}

	public static void addReserveOrder(User u, String Address) {
		
		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into orderdetails(User_id,Reserve_id,User_name,Mobile_no,Address,Ordered_cans) values"
				+ "(?,?,?,?,?,?) ";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, u.getId());
			pst.setInt(2, u.getReserveId());
			pst.setString(3,u.getName());
			pst.setLong(4,u.getMobileNo());
			pst.setString(5, Address);
			pst.setInt(6,u.getNoOfCans());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to order");
		}
	}
	


}
