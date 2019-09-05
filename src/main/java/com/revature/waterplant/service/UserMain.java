package com.revature.waterplant.service;

import java.util.Scanner;

import com.revature.waterplant.model.User;

public class UserMain {
	
	public static void main(String[] args) {

		User u = null;
		int choice = 0;
		String select = null;
		boolean bool = true;
		Scanner sc = new Scanner(System.in);
		System.out.println("((((((((((((((((Welcome to Waterplant!!!!!!))))))))))))))))\n");

		while (bool == true) {
			System.out.println("*******Enter your option*********\n 1.AdminLogin  2.NewUser  3.ExistingUser");
			select = sc.nextLine();

			if (select.equals("AdminLogin")) {
				Login.login();
				do {
					System.out.println("Select your option");
					System.out.println("1 ---->View Stock");
					System.out.println("2 ---->Update Stock");
					/*System.out.println("3 ---->View order details");
					System.out.println("4 ---->View Reserve details");*/
					System.out.println("3 ---->Quit");

					int ch = sc.nextInt();

					switch (ch) {
					case 1:

						ViewStock.stockView();
						break;
					case 2:

						UpdateStock.stockUpdate();
						break;
					/*case 3:

						break;
					case 4:
						break;*/
					case 3:
						bool = false;
						break;

					default:

						System.out.println("-----INVALID CHOICE-----\n");
						break;
					}
					System.out.println("If you want to continue\n");
				} while (bool == true);

				break;
			} else if (select.equals("NewUser")) {

				u = UserRegister.register();
				break;
			} else if (select.equals("ExistingUser")) {

				u = Login.login();

				break;
			} else {
				System.out.println("Invalid option\n");
			}
		}

		while (select.equals("NewUser") || select.equals("ExistingUser")) {

			do {

				System.out.println("1 --->Order Can");
				System.out.println("2 --->Reserve Can");
				System.out.println("3 --->OrderReserved can");
				System.out.println("4 --->Sign out\n");

				System.out.println("Enter your Choice");
				choice = sc.nextInt();

				switch (choice) {

				case 1:

					OrderCan.canOrder(u);
					break;
				case 2:
					ReserveCan.canReserve(u);
					break;
				case 3:
					ReserveOrder.orderReserve(u);

					break;
				case 4:

					bool = false;
					break;

				default:

					System.out.println("---INVALID CHOICE---\n");
					break;
				}
				System.out.println("If you want to continue\n");
			} while (bool == true);

			select = "Sign out";
		}
		System.out.println("-------THANK YOU FOR YOUR SERVICE!!! WELCOME BACK-------");

	}

	}


