package com.revature.waterplant.dao;

import com.revature.waterplant.exception.DBException;
import com.revature.waterplant.model.User;

public interface OrderDAOImp {
	
	void addOrder(User u, int noOfCans) throws DBException;
	
	void addReserveOrder(User u,int orderedCans, String Address) throws DBException;
}