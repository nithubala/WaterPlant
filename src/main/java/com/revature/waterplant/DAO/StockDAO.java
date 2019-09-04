package com.revature.waterplant.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.waterplant.Model.Stock;
import com.revature.waterplant.Util.ConnectionUtil;

public class StockDAO {

	public static Stock findStock(){
		
		Connection con = ConnectionUtil.getConnection();
		String sql = "select * from stockdetails ";
		PreparedStatement pst;
		Stock stock=null;
		try {
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				
				stock = new Stock();
				stock.setAvailableCans(rs.getInt("Available_cans"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stock;
	}

	public static void updateStock(int totalCans) {
		
		Connection con = ConnectionUtil.getConnection();
		String sql = "update stockdetails set Available_cans=? ";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,totalCans );
			pst.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
}
