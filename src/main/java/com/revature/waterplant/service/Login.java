package com.revature.waterplant.service;

import java.util.Scanner;

import com.revature.waterplant.dao.UserDAO;
import com.revature.waterplant.dao.UserDAOImp;
import com.revature.waterplant.exception.DBException;
import com.revature.waterplant.model.User;

public class Login {

	public static User login() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your Email id:");
		String emailId = s.next();
		System.out.println("Enter your password:");
		String password = s.next();
		UserDAOImp dao = new UserDAO();
		boolean b;
		try {
			b = dao.login(emailId, password);
			if (b == true) {
				System.out.println("-----LOGINNED SUCCESSFULLY-----\n");
			} else {
				System.out.println("Invalid Email-id and password");
				login();
			}
		} catch (DBException e) {

			e.printStackTrace();
		}

		User user = new User();
		user = dao.getUserID(emailId);
		System.out.println("Your id is:" + user.getId());
		return user;
	}

}
