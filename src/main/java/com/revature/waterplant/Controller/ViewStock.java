package com.revature.waterplant.Controller;

import com.revature.waterplant.DAO.StockDAO;
import com.revature.waterplant.Model.Stock;

public class ViewStock {
	
	public static void stockView() {
		Stock stock=new Stock();
		stock=StockDAO.findStock();
		System.out.println("Available cans are:"+stock.getAvailableCans());
	}

}
