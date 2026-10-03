package com.expensetracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Expense {

	private int id;
	private double amount;
	private ExpenseCategory category;
	private String description;
	private LocalDateTime dateTime;

	// Used to display the date and time in a readable format
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public Expense(int id, double amount, ExpenseCategory category, String description) {
		this.id = id;
		this.amount = amount;
		this.category = category;
		this.description = description;
		this.dateTime = LocalDateTime.now();
	}

	// Getters
	public int getId() {
		return id;
	}

	public double getAmount() {
		return amount;
	}

	public ExpenseCategory getCategory() {
		return category;
	}

	public String getDescription() {
		return description;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setCategory(ExpenseCategory category) {
		this.category = category;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// Display expense information
	public void displayDetails() {
		System.out.println("Expense ID   : " + id);
		System.out.println("Amount       : " + amount);
		System.out.println("Category     : " + category);
		System.out.println("Description  : " + description);
		System.out.println("Date and Time: " + dateTime.format(FORMATTER));
		System.out.println("-------------------------------------");
	}
}