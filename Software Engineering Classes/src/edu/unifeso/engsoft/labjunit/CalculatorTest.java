package edu.unifeso.engsoft.labjunit;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testEvaluate() {
		Calculator calc = new Calculator();
		int sum = calc.evaluate("1+2+3+4");
		assertEquals(10,sum);
	}
	
	@Test
	public void testPar() {
		Calculator calc = new Calculator();
		assertTrue(calc.par(10));
		assertFalse(calc.par(9));		
	}

}
