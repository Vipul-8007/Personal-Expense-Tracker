package com.expensetracker;

import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTrackerApp {

	public static void main(String[] args) {

		System.out.println("-------------------------------------");
		System.out.println("       PERSONAL EXPENSE TRACKER");
		System.out.println("-------------------------------------");
		System.out.println("       Welcome to Expense Tracker");
		System.out.println("\nTrack your daily expenses easily\n");

		Scanner sc = new Scanner(System.in);

		// Store all expenses while the application is running
		ArrayList<Expense> expenses = new ArrayList<>();

		MainMenu mainMenu = new MainMenu();
		mainMenu.showMainMenu(sc, expenses);

		sc.close();
	}
}