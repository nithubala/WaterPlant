package com.revature.waterplant.service;

import java.util.Scanner;

import com.revature.waterplant.dao.ReserveDAO;
import com.revature.waterplant.dao.ReserveDAOImp;
import com.revature.waterplant.dao.StockDAO;
import com.revature.waterplant.dao.StockDAOImp;
import com.revature.waterplant.exception.DBException;
import com.revature.waterplant.model.Stock;
import com.revature.waterplant.model.User;

public class ReserveCan {
	public static void canReserve(User user) {

		Scanner sc = new Scanner(System.in);
		Stock stock = new Stock();
		StockDAOImp dao = new StockDAO();
		stock = dao.findStock();
		System.out.println("Available cans are:" + stock.getAvailableCans());
		System.out.println();
		System.out.println("User can reserve only 50 cans\n");

		System.out.println("Enter the no of cans to reserve:");
		int reservedCans = sc.nextInt();

		while (reservedCans > stock.getAvailableCans() || reservedCans > 50) {
			System.out.println("Insufficient number of cans to reserve\n");
			System.out.println("Re-Enter the No of cans to reserve:");
			reservedCans = sc.nextInt();

		}
		ReserveDAOImp dao1 = new ReserveDAO();
		User u = dao1.findById(user.getId());

		if (u != null) {

			int reserveCans = u.getNoOfCans() + reservedCans;

			if (reserveCans <= 50) {
				try {
					dao1.updateReserve(u, reserveCans);
					int updateCans = stock.getAvailableCans() - reservedCans;
					dao.updateStock(updateCans);
					System.out.println("Updated successfully in stock\n");
					System.out.println("Available cans in stock after Reservation:" + updateCans);
					System.out.println();
				} catch (DBException e) {

					e.printStackTrace();
				}

				u = dao1.findById(user.getId());
				System.out.println("Reserved id is:" + u.getReserveId());
				System.out.println();
				System.out.println("Reserved cans are:" + u.getNoOfCans());
				System.out.println("--------RESERVED SUCCESSFULY IN AN EXISTING ONE---------");
			} else {
				System.out.println("Unable to Reserve more than 50,Order already Reserved Cans first\n");
			}
		}

		else {

			try {
				dao1.addReserve(user, reservedCans);
				int updateCans = stock.getAvailableCans() - reservedCans;
				dao.updateStock(updateCans);
				System.out.println("Updated successfully in stock\n");
				System.out.println("Available cans in stock after Reservation:" + updateCans);
			} catch (DBException e) {

				e.printStackTrace();
			}

			u = dao1.findById(user.getId());
			System.out.println("Reserved id is:" + u.getReserveId());
			System.out.println();
			System.out.println("--------RESERVED SUCCESSFULY---------");
		}

	}

}
