package com.training.dao;

import java.util.ArrayList;
import java.util.List;

import com.training.model.BankAccount;

public class BankAccountDao {
	
	private List<BankAccount> accounts;

	public BankAccountDao() {
		
		accounts = new ArrayList<>();
		accounts.add(new BankAccount(101, "SAVING", 15000));
		accounts.add(new BankAccount(102, "SAVING", 20000));
		accounts.add(new BankAccount(103, "CURRENt", 99000));
	}
	
	public double getBalance(int id) {
		
		return accounts.stream()
		                        .filter(account -> account.getId() == id)
		                        .mapToDouble(account -> account.getBalance())
		                        .findFirst()
		                        .getAsDouble();                        
		
	}
	
	public void updateBalance(int id, double updatedBalance) {
		
		for (BankAccount account : accounts) {
			if (account.getId() == id) {
				account.setBalance(updatedBalance);
				break;
			}
		}
	}
	
}









