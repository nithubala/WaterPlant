package com.revature.waterplant.Controller;

import java.util.Scanner;

import com.revature.waterplant.DAO.OrderDAO;
import com.revature.waterplant.DAO.ReserveDAO;
import com.revature.waterplant.Model.User;

public class ReserveOrder {
	
	public static void orderReserve(User user) {
		Scanner sc=new Scanner(System.in);
		
				
		System.out.println("please enter your reservation_id:");
		int id= sc.nextInt();
		
		User u= ReserveDAO.findByReserveId(id);
	while(u==null && u.getReserveId()==id) {
		System.out.println("Invalid Reservation id");
		System.out.println("Re-Enter your Reservation id");
		id=sc.nextInt();
		u= ReserveDAO.findByReserveId(id);
	}
	
			
          OrderDAO.addReserveOrder(u,user.getAddress());
          ReserveDAO.updateStatus(u);
	
		  System.out.println("----RESERVED CANS ORDERED SUCCCESSFULY-------");
		
		

	}

}
