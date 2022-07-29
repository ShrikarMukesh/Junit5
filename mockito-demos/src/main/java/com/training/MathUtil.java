package com.training;

import com.training.service.CalculatorService;

public class MathUtil {
	
	private CalculatorService calculatorService;
	
	public void setCalculatorService(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}
	
	public int performAddition(int x, int y) {
		return calculatorService.addition(x, y);
	}
	
	public int performSubtraction(int x, int y) {
		return calculatorService.subtraction(x, y);
	}
	
	public int performMultiplication(int x, int y) {
		return calculatorService.multiplication(x, y);
	}
	
	public int performDivision(int x, int y) {
		return calculatorService.division(x, y);
	}
	
	public long performSquare(int x) {
		return calculatorService.square(x);
	}
	
	public long performCube(int x) {
		return calculatorService.cube(x);
	}
}
