package com.ct.java.project.jdbc.demo;

import java.util.Scanner;

import com.ct.java.project.jdbc.domain.Item;
import com.ct.java.project.jdbc.domain.Person;
import com.ct.java.project.jdbc.service.Store;
import com.ct.java.project.jdbc.service.impl.FairfaxStore;
import com.ct.java.project.jdbc.utils.InputCheckingUtil;

/**
 * This project demonstrate how to use JDBC. The user once authenticated can
 * access/add/remove items from the store on his cart
 * 
 * @author christophe
 * 
 */
public class ShoppingCartDemo {

	public static void main(String[] args) {

		// Variables' declaration
		boolean authenticated = false;
		boolean goMenu = true;
		Person mPerson = null;
		Store fStore = new FairfaxStore();
		Scanner scan = new Scanner(System.in);
		String option;

		while (!authenticated) {
			// Show menu
			System.out
					.println("Hi, welcome to our menu :\n   A - Authenticate \n   B - Register ");

			// While the user doesn't enter A or B ask again
			option = " ";
			while (!(option.equals("A") || option.equals("B"))) {
				System.out.println("Enter option : ");
				option = scan.nextLine();
			}

			// Scan username and password
			String username, password;
			System.out.println("Username :");
			username = scan.nextLine();
			System.out.println("Password :");
			password = scan.nextLine();

			// if -> Authenticate or else -> Register
			if (option.equals("A")) {
				mPerson = fStore.authenticatePerson(username, password);
				if (mPerson != null) {
					authenticated = true;
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

		// Variables' Declaration
		String name;
		float price;
		Item item = null;
		long itemId;

		// Once authenticated
		while (goMenu) {

			// Show menu
			System.out
					.println("\nHi "
							+ mPerson.getUsername()
							+ "! \nYour menu :\n   A - Display items in your cart \n   B - Add an item in your cart \n   C - Remove an item from your cart \n   D - Display Items in Store \n   E - Exit");

			option = " ";

			// While the user don't enter a correct input ask again
			while (!(option.equals("A") || option.equals("B")
					|| option.equals("C") || option.equals("D") || option
						.equals("E"))) {
				System.out.println("Enter option : ");
				option = scan.nextLine();
			}

			// Show cart
			if (option.equals("A")) {
				fStore.showItemsCart(mPerson);
			}
			// Add item to cart
			else if (option.equals("B")) {
				System.out.println("Item ID : ");
				itemId = InputCheckingUtil.getLongWithChecking(scan);

				fStore.addItemToCart(itemId, mPerson);

			}
			// Remove item from cart
			else if (option.equals("C")) {
				System.out.println("Item ID : ");
				itemId = InputCheckingUtil.getLongWithChecking(scan);

				fStore.removeItemFromCart(itemId, mPerson);
			}
			// Display items in store
			else if (option.equals("D")) {
				fStore.displayItemsInStore();
			} else {
				goMenu = false;
				System.exit(0);
			}

		}

	}

}
