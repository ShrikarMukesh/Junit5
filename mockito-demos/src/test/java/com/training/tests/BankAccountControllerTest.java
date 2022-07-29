package com.training.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.training.BankAccountController;
import com.training.exception.InsufficientFundException;
import com.training.service.BankAccountService;
import com.training.service.impl.BankAccountServiceImpl;

public class BankAccountControllerTest {
	
	private BankAccountController controller;
	private BankAccountService service;
	
	@BeforeEach	
	public void setUp() {
		controller = new BankAccountController();
		BankAccountServiceImpl serviceImpl = new BankAccountServiceImpl();
		service = spy(serviceImpl);
		controller.setBankAccountService(service);
//		System.out.println(service.hashCode() + " - " + serviceImpl.hashCode());
	}
	
	@Test
	public void performWithdraw_Should_Return_UpdatedBalance_OnSuccessfulTransaction() throws InsufficientFundException {
		
		assertEquals(13000.0, controller.performWithdraw(101, 2000));
		verify(service).withdraw(101, 2000);		
	}
	
	@Test
	public void performWithdraw_Should_Throw_InsufficientFundException_OnFailedTransaction() {
		
		assertThrows(InsufficientFundException.class, () -> controller.performWithdraw(101, 20000));
	}
	
	@Test
	public void performDeposit_Should_Return_UpdatedBalance_OnSuccessfulTransaction() {
		
		assertEquals(20000.0, controller.performDeposit(101, 5000));
		verify(service).deposit(101, 5000);
	}
	
	@Test
	public void getCurrentBalance_Should_Return_Correct_Balance() {
		
	      // when(service.checkBalance(101)).thenReturn(15000.0);  // Don't use with spy object because it calls the real method.
	      doReturn(15000.0).when(service).checkBalance(101);   	  // Use in case of spy object because it will not call real method.     
	      
	      assertEquals(15000.0, controller.getCurrentBalance(101));	  
	      verify(service).checkBalance(101);
	}
	
	@Test
	public void performFundTransfer_Should_Return_UpdatedBalance_OnSuccessfulTransaction() throws InsufficientFundException {
		
		doReturn(10000.0).when(service).fundTransfer(101, 102, 5000);
		
		assertEquals(10000.0, controller.performFundTransfer(101, 102, 5000));
		verify(service).fundTransfer(101, 102, 5000);
	}
	
	@Test
	public void performFundTransfer_Should_Throw_InsufficientFundException_OnFailedTransaction() throws InsufficientFundException {
		
		doThrow(InsufficientFundException.class).when(service).fundTransfer(101, 102, 17000);
		
		assertThrows(InsufficientFundException.class, () ->  controller.performFundTransfer(101, 102, 17000));
	}
}	


























