package com.revature.waterplant.service;

import java.util.Scanner;

import com.revature.waterplant.dao.UserDAO;
import com.revature.waterplant.dao.UserDAOImp;
import com.revature.waterplant.exception.DBException;
import com.revature.waterplant.model.User;

public class UserRegister {
static Scanner s=new Scanner(System.in); 
	
	public static User register() {
		
		System.out.println("Enter your Name:");
		String name=s.nextLine();
		System.out.println("Enter your emailid:");
		String emailId = s.nextLine();
		System.out.println("Enter your password:");
		String password = s.nextLine();
		System.out.println("Enter your Address:");
		String address = s.nextLine();
		System.out.println("Enter your Mobileno:");
		long mobileNo = s.nextLong();
		
		User user=new User();
		user.setName(name);
		user.setEmailId(emailId);
		user.setPassword(password);
		user.setAddress(address);
		user.setMobileNo(mobileNo);
		
		System.out.println(user);
		UserDAOImp dao=new UserDAO();
		try {
			dao.register(user);
		} catch (DBException e) {
			e.printStackTrace();
		}
		System.out.println("------REGISTERED SUCCESSFULLY-------");
		user=Login.login();
		return user;
		
	}
}
