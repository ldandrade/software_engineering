package edu.unifeso.engsoft.labjunit;

public class Calculator {

	public int evaluate(String expression) {
		int sum = 0;
		for (String summand: expression.split("\\+"))
			sum +=Integer.valueOf(summand);
		return sum;
	}
	
	public boolean par(int num) {
		if (num % 2 == 0)
			return true;
		return false;
	}
}
