package edu.java.completereference.ootbfunctionalinterfaces;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Predefined Functional Interfaces - Use the Function built-in functional interface.
 *  - Built-in Function interface could have been used, as this version of the program illustrates:
 * 
 * @author - Ritesh
 * @version 1.0
 * @since <07-July-2017>
 */
class UseFunctionInterfaceDemo {

	public static void main(String[] args) {

		/*
		 * This block lambda computes the factorial of an int value.
		 * This time, Function is the functional interface.
		 */
		Function<Integer, Integer> factorial = (n) -> {
			int result = 1;
			for (int i = 1; i <= n; i++)
				result = i * result;
			return result;
		};
		System.out.println("The factoral of 3 is " + factorial.apply(3));
		System.out.println("The factoral of 5 is " + factorial.apply(5));
		
		Function<String, Integer> strLen = (str) -> {
			return str.length();
		};
		System.out.println("Length of 'Ritesh' is " + strLen.apply("Ritesh"));
		System.out.println("Length of 'LOL' is " + strLen.apply("LOL"));
		
		/*
		 * Note:
		 * Function<T, R> Apply an operation to an object of type T 
		 * and return the result as an object of type R. Its method is called apply( ).
		 */
		
		UnaryOperator<Integer> plusTen = (n) -> n + 10;
		System.out.println("Result is " + plusTen.apply(55));
	}
}
