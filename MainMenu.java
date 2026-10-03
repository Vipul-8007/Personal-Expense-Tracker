package com.expensetracker;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

	private ExpenseMenu expenseMenu = new ExpenseMenu();

	// Display the main menu
	public void showMainMenu(Scanner sc, ArrayList<Expense> expenses) {

		boolean running = true;

		while (running) {
			System.out.println("\n========== MAIN MENU ==========");
			System.out.println("1. Expense Menu");
			System.out.println("2. Application Details");
			System.out.println("3. Expense Categories");
			System.out.println("4. Help");
			System.out.println("5. Exit");
			System.out.println("===============================");

			int choice = readInt(sc, "Enter your choice: ");

			switch (choice) {
			case 1:
				expenseMenu.showMenu(sc, expenses);
				break;

			case 2:
				showApplicationDetails(sc);
				break;

			case 3:
				showCategories(sc);
				break;

			case 4:
				showHelp(sc);
				break;

			case 5:
				System.out.println("Thank you for using Expense Tracker!");
				running = false;
				break;

			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	// Read an integer without crashing if the user enters text
	private int readInt(Scanner sc, String message) {

		while (true) {
			System.out.print(message);
			String input = sc.nextLine();

			try {
				return Integer.parseInt(input.trim());
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid number.");
			}
		}
	}

	// Show application information
	private void showApplicationDetails(Scanner sc) {

		System.out.println("\n------ APPLICATION DETAILS ------");
		System.out.println("Application : Personal Expense Tracker");
		System.out.println("Language    : Java");
		System.out.println("Type        : Console Based Application");
		System.out.println("Purpose     : Manage daily expenses");
		System.out.println("---------------------------------");

		showBackMessage(sc);
	}

	// Display all available categories
	private void showCategories(Scanner sc) {

		System.out.println("\n------ EXPENSE CATEGORIES ------");
		for (ExpenseCategory category : ExpenseCategory.values()) {
			System.out.println("- " + category);
		}
		System.out.println("--------------------------------");

		showBackMessage(sc);
	}

	// Explain how to use the application
	private void showHelp(Scanner sc) {

		System.out.println("\n--------------- HELP ---------------");
		System.out.println("1. Open Expense Menu to manage expenses.");
		System.out.println("2. Add an expense with amount and category.");
		System.out.println("3. View or delete saved expenses.");
		System.out.println("4. Calculate total and highest expense.");
		System.out.println("5. View category-wise expense totals.");
		System.out.println("6. Select Exit to close the application.");
		System.out.println("------------------------------------");

		showBackMessage(sc);
	}

	// Return to the main menu after viewing information
	private void showBackMessage(Scanner sc) {

		int choice = readInt(sc, "Enter 0 to return to Main Menu: ");

		if (choice != 0) {
			System.out.println("Returning to Main Menu.");
		}
	}
}