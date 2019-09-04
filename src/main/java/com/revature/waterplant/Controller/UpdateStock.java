package com.revature.waterplant.Controller;

import java.util.Scanner;

import com.revature.waterplant.DAO.StockDAO;
import com.revature.waterplant.Model.Stock;

public class UpdateStock {
	public static void stockUpdate() {
		Scanner sc= new Scanner(System.in);
		Stock stock=new Stock();
		stock=StockDAO.findStock();
		System.out.println("Available cans are:"+stock.getAvailableCans());
		System.out.println("Enter the no of cans to add:");
		int addCans=sc.nextInt();
		
		int totalCans=stock.getAvailableCans()+addCans;
		StockDAO.updateStock(totalCans);
		System.out.println("----------STOCK UPDATED SUCCESSFULLY-------");
		
		stock=StockDAO.findStock();
		System.out.println("Available cans after update:"+stock.getAvailableCans());
		
		
	}


}
