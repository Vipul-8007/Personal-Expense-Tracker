package com.expensetracker;

import java.util.*;

public class ExpenseMenu {

	private int nextId = 1;

	public void showMenu(Scanner sc, ArrayList<Expense> expenses) {

		boolean menuRunning = true;

		while (menuRunning) {

			System.out.println("\n===== Expense Menu =====\n");

			System.out.println("1. Add Expense");
			System.out.println("2. Display All Expenses");
			System.out.println("3. Delete Expense");
			System.out.println("4. Calculate Total Expense");
			System.out.println("5. Find Highest Expense");
			System.out.println("6. Calculate Category-wise Expenses");
			System.out.println("7. Back to Main Menu");

			System.out.print("\nEnter Your Choice : ");

			int choice = sc.nextInt();

			System.out.println();

			switch (choice) {

			case 1: {

				System.out.print("Enter Amount : ");

				double amount = sc.nextDouble();

				sc.nextLine();

				if (amount <= 0) {

					System.out.println("Amount must be greater than zero");

					break;
				}

				ExpenseCategory category = null;

				while (category == null) {

					System.out.print("Enter category (FOOD, TRAVEL, SHOPPING, BILLS, OTHER) : ");

					String categoryInput = sc.nextLine().trim().toUpperCase();

					try {

						category = ExpenseCategory.valueOf(categoryInput);

					} catch (IllegalArgumentException e) {

						System.out.println("Invalid Category. Try Again");
					}
				}

				System.out.print("Enter Description : ");

				String description = sc.nextLine();

				Expense expense = new Expense(nextId, amount, category, description);

				expenses.add(expense);

				nextId++;

				System.out.println("Expense Added Successfully");

				break;
			}

			case 2: {

				if (expenses.isEmpty()) {

					System.out.println("No Expense found");

				} else {

					for (Expense e : expenses) {

						e.displayDetails();

						System.out.println("------------------------------");
					}
				}

				break;
			}

			case 3: {

				if (expenses.isEmpty()) {

					System.out.println("No expenses found");

				} else {

					System.out.print("Enter Expense ID to delete : ");

					int deleteId = sc.nextInt();

					boolean found = false;

					for (int i = 0; i < expenses.size(); i++) {

						if (expenses.get(i).getId() == deleteId) {

							expenses.remove(i);

							found = true;

							System.out.println("Expense deleted successfully");

							break;
						}
					}

					if (!found) {

						System.out.println("Expense ID not found");
					}
				}

				break;
			}

			case 4: {

				double total = expenses.stream().mapToDouble(Expense::getAmount).sum();

				System.out.println("Total Expense : " + total);

				break;
			}

			case 5: {

				if (expenses.isEmpty()) {

					System.out.println("No expenses found");

				} else {

					Optional<Expense> highestExpense = expenses.stream()
							.max(Comparator.comparingDouble(Expense::getAmount));

					highestExpense.ifPresent(e -> {

						System.out.println("Highest Expense : " + e.getAmount());

						System.out.println();

						e.displayDetails();
					});
				}

				break;
			}

			case 6: {

				HashMap<ExpenseCategory, Double> categoryTotals = new HashMap<>();

				for (Expense e : expenses) {

					ExpenseCategory category = e.getCategory();

					double amount = e.getAmount();

					if (categoryTotals.containsKey(category)) {

						categoryTotals.put(category, categoryTotals.get(category) + amount);

					} else {

						categoryTotals.put(category, amount);
					}
				}

				if (categoryTotals.isEmpty()) {

					System.out.println("No expenses found");

				} else {

					for (Map.Entry<ExpenseCategory, Double> entry : categoryTotals.entrySet()) {

						System.out.println(entry.getKey() + " : " + entry.getValue());
					}
				}

				break;
			}

			case 7: {

				menuRunning = false;

				System.out.println("Returning to Main Menu...");

				break;
			}

			default:

				System.out.println("Invalid Choice. Try Again");
			}
		}
	}
}