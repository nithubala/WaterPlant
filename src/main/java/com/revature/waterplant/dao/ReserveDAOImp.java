package com.revature.waterplant.dao;

import com.revature.waterplant.exception.DBException;
import com.revature.waterplant.model.User;

public interface ReserveDAOImp {
	
	 void addReserve(User user, int reservedCans) throws DBException ;
	 
	 User findById(int id);
	 
	 void updateReserve(User u, int reservedCans) throws DBException;
	 
	 User findByReserveId(int id);
	 
	 void updateStatus(User u,int orderedCans);

}
