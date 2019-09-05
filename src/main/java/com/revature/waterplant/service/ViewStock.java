package com.revature.waterplant.service;

import java.util.List;

import com.revature.waterplant.dao.StockDAO;
import com.revature.waterplant.dao.StockDAOImp;
import com.revature.waterplant.exception.DBException;
import com.revature.waterplant.model.Stock;

public class ViewStock {

	public static void stockView() {

		StockDAOImp dao = new StockDAO();
		List<Stock> list;
		try {
			list = dao.viewStock();
			for (Stock stock : list) {

				System.out.println("Available cans are:" + stock.getAvailableCans() + " ON " + stock.getDate());

			}
		} catch (DBException e) {

			e.printStackTrace();
		}

		System.out.println();
	}

}
