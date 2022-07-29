package com.training.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.training.MathUtil;
import com.training.service.CalculatorService;

@ExtendWith(MockitoExtension.class)
public class MathUtilTest {
	
	@InjectMocks
	private MathUtil mathUtil;
	
	@Mock
	private CalculatorService calculatorService;
	
	@Test
	public void performAddition_Should_Return_CorrectValue_For_TwoPositiveIntegers() {
		
		when(calculatorService.addition(12, 15)).thenReturn(27);
		
		assertEquals(27, mathUtil.performAddition(12, 15));
		assertEquals(27, mathUtil.performAddition(12, 15));
	    assertEquals(27, mathUtil.performAddition(12, 15));
		
		// verify(calculatorService).addition(12, 15);   // It checks for only one invocation
		
		// verify(calculatorService, times(3)).addition(12, 15);
		
		// verify(calculatorService, never()).addition(12, 11);
		
		// verify(calculatorService, atLeast(2)).addition(12, 15);
	    
	    verify(calculatorService, atMost(3)).addition(12, 15);
	}
	
	@Test
	public void performDivision_Should_Return_CorrectResult_WhenDivisorIsNotZero() {
		
		when(calculatorService.division(12, 6)).thenReturn(2);
		
		assertEquals(2, mathUtil.performDivision(12, 6));
		verify(calculatorService).division(12, 6);
		
		verify(calculatorService, timeout(1000).times(1)).division(12, 6);
	}
	
	@Test
	public void performDivision_Should_Throw_ArithmeticException_WhenDivisorIsZero() {
		
		doThrow(ArithmeticException.class).when(calculatorService).division(12, 0);
		
		assertThrows(ArithmeticException.class, () -> mathUtil.performDivision(12,  0));		
	}
	
	@Test
	public void test() {
		
		when(calculatorService.addition(12, 4)).thenReturn(16);
		when(calculatorService.subtraction(30, 15)).thenReturn(15);
		when(calculatorService.multiplication(12, 6)).thenReturn(72);
		
		assertEquals(16, mathUtil.performAddition(12, 4));
		assertEquals(15, mathUtil.performSubtraction(30, 15));
		assertEquals(72, mathUtil.performMultiplication(12, 6));
		
		InOrder order = inOrder(calculatorService);
		
		order.verify(calculatorService).addition(12, 4);	
		order.verify(calculatorService).subtraction(30, 15);	
		order.verify(calculatorService).multiplication(12, 6);
	}
}





























