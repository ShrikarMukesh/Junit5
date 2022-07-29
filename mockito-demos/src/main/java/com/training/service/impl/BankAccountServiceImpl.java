package com.training.service.impl;

import com.training.dao.BankAccountDao;
import com.training.exception.InsufficientFundException;
import com.training.service.BankAccountService;

public class BankAccountServiceImpl implements BankAccountService {
	
	private BankAccountDao dao = new BankAccountDao();

	@Override
	public double withdraw(int id, double amount) throws InsufficientFundException {
//		System.out.println("Inside withdraw() method of BankAccountServiceImpl");
		double balance = dao.getBalance(id);
		if (balance < amount)
			throw new InsufficientFundException("You don't have sufficient fund.");
		else {
			double updatedBalance = balance - amount;
			dao.updateBalance(id, updatedBalance);
			return updatedBalance;
		}		
	}

	@Override
	public double deposit(int id, double amount) {
		double balance = dao.getBalance(id);
		double updatedBalance = balance + amount;
		dao.updateBalance(id, updatedBalance);
		return updatedBalance;
	}

	@Override
	public double checkBalance(int id) {
		// Unimplemented method
		System.out.println("Inside checkBalance() method");
		return 0;
	}

	@Override
	public double fundTransfer(int fromAccId, int toAccId, double amount) throws InsufficientFundException {
		// Unimplemented methods
		return 0;
	}

}















