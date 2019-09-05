package com.revature.waterplant.dao;

import java.util.List;

import com.revature.waterplant.exception.DBException;
import com.revature.waterplant.model.Stock;

public interface StockDAOImp {
	
	Stock findStock();
	
	List<Stock> viewStock()throws DBException;
	
	void updateStock(int totalCans) throws DBException ;

}
