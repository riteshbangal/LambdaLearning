package edu.java.completereference.lambdaexpressions;

/**
 * A block lambda that computes the factorial of an int value.
 * 
 * @author - Ritesh
 * @version 1.0
 * @since <07-July-2017>
 */
class BlockLambdaDemo {
	public static void main(String args[]) {
		// This block lambda computes the factorial of an int value.
		NumericFunc factorial = (n) -> {
			int result = 1;
			for (int i = 1; i <= n; i++)
				result = i * result;
			return result;
		};
		
		System.out.println("The factoral of 3 is " + factorial.func(3));
		System.out.println("The factoral of 5 is " + factorial.func(5));
	}
}

/**
 * A functional interface is an interface that specifies only one abstract
 * method.
 */
interface NumericFunc {
	int func(int n);
}
