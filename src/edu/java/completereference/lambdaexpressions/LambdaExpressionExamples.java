package edu.java.completereference.lambdaexpressions;

/**
 * Demonstrate a simple lambda expression, which takes a number as input.
 * 
 * @author - Ritesh
 * @version 1.0
 * @since <07-July-2017>
 */
public class LambdaExpressionExamples {
	
	public static void main(String args[]) {
		
		// declare an interface reference
		CheckNumber checkNumber; 
		
		/* 
		 * This lambda expression returns true if the value of parameter n is even.
		 */
		checkNumber = (n) -> (n % 2) == 0;
		
		// Call check(), which is provided by the previously assigned lambda expression.
		System.out.println("Even check: " + checkNumber.check(5));
	}
}

/**
 * A functional interface is an interface that specifies only one abstract method.
 */
interface CheckNumber {
	boolean check(int input);
}