package com.revature.waterplant.Controller;

import java.util.Scanner;

import com.revature.waterplant.DAO.ReserveDAO;
import com.revature.waterplant.DAO.StockDAO;
import com.revature.waterplant.Model.Stock;
import com.revature.waterplant.Model.User;

public class ReserveCan {
	public static void canReserve(User user) {
		
		
		Scanner sc=new Scanner(System.in);
		Stock stock=new Stock();
		stock=StockDAO.findStock();
		System.out.println("Available cans are:"+stock.getAvailableCans());
		
		System.out.println("User can reserve only 50 cans");
		
		System.out.println("Enter the no of cans to reserve:");
		int reservedCans=sc.nextInt();
		
		while(reservedCans>stock.getAvailableCans() && reservedCans>50) {
			System.out.println("Insufficient number of cans to reserve");
			System.out.println("Re-Enter the No of cans to reserve");
			reservedCans=sc.nextInt();
			
		}
		
	User u= ReserveDAO.findById(user.getId());
		//System.out.println(u);
		 if(u !=null)
		 {
			 
			 int reserveCans=u.getNoOfCans()+reservedCans;
			 if(reserveCans<=50) {
			 ReserveDAO.updateReserve(u,reserveCans);
			 int updateCans=stock.getAvailableCans()-reservedCans;
			 StockDAO.updateStock(updateCans);
			 
			   u= ReserveDAO.findById(user.getId());
			   System.out.println("Reserved id is:"+u.getId());
			   System.out.println("Reserved cans are:"+u.getNoOfCans());
			   System.out.println("--------RESERVED SUCCESSFULY---------");
			 }
			 else {
				 System.out.println("Unable to Reserve,Order the Reserved Cans first");
			 }
		 }
		 
		 else {
	   // System.out.println(user);
		ReserveDAO.addReserve(user,reservedCans);
		
		int updateCans=stock.getAvailableCans()-reservedCans;
	    StockDAO.updateStock(updateCans);
	    
	       u= ReserveDAO.findById(user.getId());
		   System.out.println("Reserved id is:"+u.getId());
		   System.out.println("Reserved cans are:"+u.getNoOfCans());
		   System.out.println("--------RESERVED SUCCESSFULY---------");
		 }
	   
	   
	  
		 
		
	}

}
