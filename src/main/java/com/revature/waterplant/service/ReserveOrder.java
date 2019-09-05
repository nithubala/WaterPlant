package com.revature.waterplant.service;

import java.util.Scanner;

import com.revature.waterplant.dao.OrderDAO;
import com.revature.waterplant.dao.OrderDAOImp;
import com.revature.waterplant.dao.ReserveDAO;
import com.revature.waterplant.dao.ReserveDAOImp;
import com.revature.waterplant.dao.StockDAO;
import com.revature.waterplant.dao.StockDAOImp;
import com.revature.waterplant.exception.DBException;
import com.revature.waterplant.model.Stock;
import com.revature.waterplant.model.User;

public class ReserveOrder {
	
	public static void orderReserve(User user) {
		Scanner sc=new Scanner(System.in);
		boolean b=true;
				
		System.out.println("please enter your Reservation id:");
		int id= sc.nextInt();
		
		ReserveDAOImp dao=new ReserveDAO();
		User u= dao.findByReserveId(id);
		
		while(u==null) {
		System.out.println("Invalid Reservation id");
		System.out.println("Re-Enter your Reservation id");
		id=sc.nextInt();
		u= dao.findByReserveId(id);
	}
	    int reserveCans=u.getNoOfCans();
		System.out.println("Reserved cans are:"+reserveCans);
		System.out.println();
		
		
		while(b) {
			System.out.println("Enter the number of cans to order:");
			int orderedCans=sc.nextInt();
			if(orderedCans<=reserveCans){
				
			StockDAOImp dao1=new StockDAO();	
			Stock stock=dao1.findStock();
		    int addCans=reserveCans-orderedCans;
			int updateCans=stock.getAvailableCans()+addCans;
			
		    try {
		    	dao.updateStatus(u,orderedCans);
		    	dao1.updateStock(updateCans);
		    	OrderDAOImp dao2=new OrderDAO();
		    	dao2.addReserveOrder(u,orderedCans,user.getAddress());
		    	b=false;
			} catch (DBException e) {
				e.printStackTrace();
			}
		    System.out.println("Updated successfully in stock\n");
			System.out.println("------RESERVED CANS ORDERED SUCCCESSFULY-------");
			
			}
			else {
				System.out.println("Enter the cans below:"+reserveCans);
			}
			
		}
	
			
       }

}
