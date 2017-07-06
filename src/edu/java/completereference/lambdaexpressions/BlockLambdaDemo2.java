package edu.java.completereference.lambdaexpressions;

/**
 * A block lambda that reverses the characters in a string.
 * 
 * @author - Ritesh
 * @version 1.0
 * @since <08-July-2017>
 */
class BlockLambdaDemo2 {
	public static void main(String args[]) {
		// This block lambda reverses the characters in a string.
		StringFunc reverse = (str) -> {
			String result = "";
			int i;
			for (i = str.length() - 1; i >= 0; i--)
				result += str.charAt(i);
			return result;
		};
		System.out.println("Lambda reversed is: " + reverse.func("Lambda"));
		System.out.println("Expression reversed is: " + reverse.func("Expression"));
	}
}

/**
 * A functional interface is an interface that specifies only one abstract method.
 */
interface StringFunc {
	String func(String n);
}
