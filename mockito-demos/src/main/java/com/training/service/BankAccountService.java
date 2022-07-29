package com.training.service;

import com.training.exception.InsufficientFundException;

public interface BankAccountService {
	
	public double withdraw(int id, double amount) throws InsufficientFundException;
	public double deposit(int id, double amount);
	public double checkBalance(int id);
	public double fundTransfer(int fromAccId, int toAccId, double amount) throws InsufficientFundException;
}
