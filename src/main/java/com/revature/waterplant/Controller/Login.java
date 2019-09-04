package com.revature.waterplant.Controller;

import java.util.Scanner;

import com.revature.waterplant.DAO.UserDAO;
import com.revature.waterplant.Model.User;

public class Login {
	
public static User login() {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter your Email id:");
		String emailId=s.next();
		System.out.println("Enter your password:");
		String password = s.next();
		
		boolean b=UserDAO.login(emailId,password);
		if(b==true) {
			System.out.println("-----LOGINNED SUCCESSFULLY-----\n");
		}
		else {
			System.out.println("Invalid Username and password");
		    login();
		}
		User user=new User();
		user=UserDAO.getUserID(emailId);
		System.out.println("Your User id is:"+user.getId());
		return user;
	}

}
