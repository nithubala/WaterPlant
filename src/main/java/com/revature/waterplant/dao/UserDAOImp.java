package com.revature.waterplant.dao;

import com.revature.waterplant.exception.DBException;
import com.revature.waterplant.model.User;

public interface UserDAOImp {
	
	void register(User user)throws DBException;
	
	boolean login(String emailId, String password)throws DBException;
	
	User getUserID(String emailId);

}
