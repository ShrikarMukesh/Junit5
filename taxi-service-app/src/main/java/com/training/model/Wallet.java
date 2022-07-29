package com.training.model;

public class Wallet {

	private int balance;

	public Wallet() {
		super();
	}

	public Wallet(int balance) {
		super();
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void spend(int amount) {
		balance = balance -amount;	
	}
	
	public void deposit(int amount) {
		balance = balance + amount;
	}
}










