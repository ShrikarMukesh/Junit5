package com.training.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.training.MathUtil;

public class MathUtilTest {

	  @Test
	  public void testAdditionWithTwoPositiveNumbersAsInput() {
//		  int x = 10;
//		  int y = 20;
//		  int result = MathUtil.addition(x, y);
//		  int expectedResult = 30;
//		  
//		  // assert => expected value and actual value
//		  assertEquals(expectedResult, result);
		  
		  assertEquals(30, MathUtil.addition(10, 20));
	  }
	  
	  @Test
	  public void testAdditionWithOnePositiveAndOneNegativeNumberAsInut() {
		  
		  assertEquals(18, MathUtil.addition(-12, 30));
	  }
	  
	  @Test
	  public void testAdditionWithBothNegativeNumbersAsInput() {
		  
		  assertEquals(-36, MathUtil.addition(-12, -24));
	  }
}



















