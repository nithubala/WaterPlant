package com.revature.waterplant.service;

import java.util.Scanner;

import com.revature.waterplant.dao.OrderDAOImp;
import com.revature.waterplant.dao.StockDAO;
import com.revature.waterplant.dao.OrderDAO;
import com.revature.waterplant.dao.StockDAOImp;
import com.revature.waterplant.exception.DBException;
import com.revature.waterplant.model.Stock;
import com.revature.waterplant.model.User;

public class OrderCan {
	
	public static void canOrder(User user) {
	

    Scanner sc=new Scanner(System.in);
	Stock stock=new Stock();
	StockDAOImp dao=new StockDAO();
	stock=dao.findStock();
	System.out.println("Available cans are:"+stock.getAvailableCans());
	System.out.println();
	System.out.println("User can order only 100 cans at once\n");
	System.out.println("Enter the No of cans Required:");
	int noOfCans=sc.nextInt();
	
	while(noOfCans > stock.getAvailableCans() || noOfCans>100) {
		System.out.println("Insufficient number of cans\n");
		System.out.println("Re-Enter the No of cans Required");
	    noOfCans=sc.nextInt();
		}
	
	
		try {
			OrderDAOImp dao1=new OrderDAO();
			dao1.addOrder(user,noOfCans);
			int updateCans=stock.getAvailableCans()-noOfCans;
			dao.updateStock(updateCans);
		} catch (DBException e) {
			
			e.printStackTrace();
		}
		
	System.out.println("------------ORDERED SUCCESSFULY-----------");
		
	
	
	
	}
}
