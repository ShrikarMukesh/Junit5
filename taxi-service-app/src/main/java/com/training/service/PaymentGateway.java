package com.training.service;

import com.training.model.CreditCard;

public interface PaymentGateway {

	int SUCCESS = 0;
	int INVALID_CREDIT_CARD_DETAILS = 1;
	int INSUFFICIENT_BALANCE = 2;
	
	public void connect();	
	public int charge(CreditCard card, int amount);
}
