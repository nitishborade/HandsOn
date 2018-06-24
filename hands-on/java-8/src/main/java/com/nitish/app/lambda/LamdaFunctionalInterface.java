package com.nitish.app.lambda;

public class LamdaFunctionalInterface {

	public static void main(String... args) {
		Calculator calc = new Calculator();
		System.out.println(calc.calculate(30d, 20d, (a, b) -> a + b ));
		
		DoubleOperator o = (a, b) -> a - b;
		System.out.println(calc.calculate(30d, 20d, o));
		
		//find the smallest operand using a ternary operator
		Double result4 = calc.calculate(666d, 777d, (a, b) -> a > b ? b : a);
		System.out.println(result4); //666.0 
	}
}

class Calculator {
	public Double calculate(Double a, Double b, DoubleOperator o) {
		return o.apply(a, b);
	}
}

/**
 * @author Nitish
 * 
 * 1. Fuctional Interface can have only one abstract method.
 * 2. In this example Functional Interface with the help of lambda simplifies and elimitates the need to have various methods like add, sub, multiply, divide, square etc. We just focus on the behaviour, the functionality rather than then writing all these methods to perform these operations.
 * 3. It prevent us from writing anonymous classes which one would right to implement apply
 * 		new DoubleOperator() {
			@Override
			public Double apply(Double a, Double b) {
				return null;
			}
		};
 * 
 *
 */
@FunctionalInterface
interface DoubleOperator {
    Double apply(Double a, Double b);
}
