package com.revature.waterplant.Controller;

import java.util.Scanner;

import com.revature.waterplant.DAO.OrderDAO;
import com.revature.waterplant.DAO.ReserveDAO;
import com.revature.waterplant.DAO.StockDAO;
import com.revature.waterplant.Model.Stock;
import com.revature.waterplant.Model.User;

public class OrderCan {
	
	public static void canOrder(User user) {
	

    Scanner sc=new Scanner(System.in);
	Stock stock=new Stock();
	stock=StockDAO.findStock();
	System.out.println("Available cans are:"+stock.getAvailableCans());
	
	//System.out.println("User can order only 100 cans at once");
	
	System.out.println("Enter the No of cans Required");
	int noOfCans=sc.nextInt();
	
	while(noOfCans > stock.getAvailableCans() && noOfCans>100) {
		System.out.println("Insufficient number of cans");
		System.out.println("Re-Enter the No of cans Required");
	    noOfCans=sc.nextInt();
		}
	
	
		OrderDAO.addOrder(user,noOfCans);
		
		int updateCans=stock.getAvailableCans()-noOfCans;
		
		StockDAO.updateStock(updateCans);
		System.out.println("--------ORDERED SUCCESSFULY---------");
		
	
	
	
	}
}
