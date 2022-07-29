package com.training;

import com.training.exception.InsufficientFundException;
import com.training.service.BankAccountService;

public class BankAccountController {
	
	private BankAccountService bankAccountService;
	
	public void setBankAccountService(BankAccountService bankAccountService) {
		this.bankAccountService = bankAccountService;
	}
	
	public double performWithdraw(int id, double amount) throws InsufficientFundException {
		return bankAccountService.withdraw(id, amount);
	}
	
	public double performDeposit(int id, double amount) {
		return bankAccountService.deposit(id, amount);
	}
	
	public double getCurrentBalance(int id) {
		return bankAccountService.checkBalance(id);				
	}
	
	public double performFundTransfer(int fromAccId, int toAccId, double amount) throws InsufficientFundException {
		return bankAccountService.fundTransfer(fromAccId, toAccId, amount);
	}

}
