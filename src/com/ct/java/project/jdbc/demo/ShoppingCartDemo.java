package com.ct.java.project.jdbc.demo;

import java.util.Scanner;

import com.ct.java.project.jdbc.domain.Item;
import com.ct.java.project.jdbc.domain.Person;
import com.ct.java.project.jdbc.service.FairfaxStore;
import com.ct.java.project.jdbc.service.Store;
import com.ct.java.project.jdbc.utils.InputCheckingUtil;

public class ShoppingCartDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean succeeded = false;
		boolean goMenu = true;
		Person mPerson = null;
		Store fStore = new FairfaxStore();
		Scanner scan = new Scanner(System.in);
		String option;

		while (!succeeded) {
			System.out
					.println("Hi, welcome to our menu :\n   A - Authenticate \n   B - Register ");

			option =" ";
			while (!(option.equals("A") || option.equals("B"))){
				System.out.println("Enter option : ");
				option = scan.nextLine();
			}
		

			String username, password;
			System.out.println("Username :");
			username = scan.nextLine();
			System.out.println("Password :");
			password = scan.nextLine();
			if (option.equals("A")) {
				mPerson = fStore.authenticatePerson(username, password);
				if (mPerson != null) {
					succeeded = true;
				} else {
					System.out
							.println("Something went wrong, please restart. \n ");
				}
			} else {
				mPerson = new Person(username, password); 
				if (fStore.register(mPerson)) {
					System.out.println(username + " was registered");
				} else {
					System.out
							.println("Something went wrong, please restart. \n ");
				}
			}
		}

		while (goMenu) {
			System.out
					.println("\nHi "
							+ mPerson.getUsername()
							+ "! \nYour menu :\n   A - Display items in your cart \n   B - Add an item in your cart \n   C - Remove an item from your cart \n   D - Display Items in Store \n   E - Exit");
			String name;
			float price;
			Item item = null;
			long itemId;
			
			option = " ";
			while (!(option.equals("A") || option.equals("B")
					|| option.equals("C") || option.equals("D")
					|| option.equals("E"))) {
				System.out.println("Enter option : ");
				option = scan.nextLine();
			} 

			if (option.equals("A")) {
				fStore.showItemsCart(mPerson);
			} else if (option.equals("B")) {
				System.out.println("Item ID : ");
				itemId = InputCheckingUtil.getLongWithChecking(scan);

				fStore.addItemToCart(itemId, mPerson);;
			} else if (option.equals("C")) {
				System.out.println("Item ID : ");
				itemId = InputCheckingUtil.getLongWithChecking(scan);
				
				fStore.removeItemFromCart(itemId, mPerson);
			} else if (option.equals("D")) {
				fStore.displayItemsInStore();
			} else {
				goMenu = false;
				System.exit(0);
			}

		}

	}

}
