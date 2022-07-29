package com.training;

public class MathUtil {

	public static int addition(int x, int y)  {
		return x + y;
	}
	
	public static int subtraction(int x, int y)  {
		return x - y;
	}
	
	public static long power(int x, int y) {
		
		if (y == 0)
			return 1;
		else
			return x * power(x, y-1);
	}
	
	public static boolean isOdd(int n) {
		return n % 2 != 0;
	}
	
	// This function returns true if string is null, "", "   "
	public static boolean isBlank(String s) {
		if (s == null || s.trim().isEmpty()) 
			return true;
		return false;
	}

}















