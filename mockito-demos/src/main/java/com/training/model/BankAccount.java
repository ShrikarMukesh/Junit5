package com.training.model;

public class BankAccount {

	private int id;
	private String type;
	private double balance;

	public BankAccount() {
		super();
	}

	public BankAccount(int id, String type, double balance) {
		super();
		this.id = id;
		this.type = type;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
