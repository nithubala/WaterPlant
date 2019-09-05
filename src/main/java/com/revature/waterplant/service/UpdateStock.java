package com.revature.waterplant.service;

import java.util.Scanner;

import com.revature.waterplant.dao.StockDAO;
import com.revature.waterplant.dao.StockDAOImp;
import com.revature.waterplant.exception.DBException;
import com.revature.waterplant.model.Stock;

public class UpdateStock {
	public static void stockUpdate() {
		Scanner sc= new Scanner(System.in);
		Stock stock=new Stock();
		StockDAOImp dao = new StockDAO();
		stock=dao.findStock();
		System.out.println("Available cans are:"+stock.getAvailableCans());
		System.out.println();
		System.out.println("Enter the no of cans to add:");
		int addCans=sc.nextInt();
		
		int totalCans=stock.getAvailableCans()+addCans;
		try {
			dao.updateStock(totalCans);
		} catch (DBException e) {
			
			e.printStackTrace();
		}
		System.out.println("----------STOCK UPDATED SUCCESSFULLY-------\n");
		
		stock=dao.findStock();
		System.out.println("Available cans after update are :"+stock.getAvailableCans());
		System.out.println();
		
	}


}
