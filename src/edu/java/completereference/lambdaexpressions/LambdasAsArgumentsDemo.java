package edu.java.completereference.lambdaexpressions;

/**
 * Use lambda expressions as an argument to a method.
 * It is a very powerful use because it gives you a way to pass executable code as an argument to a method.
 * 
 * The following program shows this approach:
 * 
 * @author - Ritesh
 * @version 1.0
 * @since <08-July-2017>
 */
class LambdasAsArgumentsDemo {
	
	/*
	 * This method has a functional interface as the type of its first parameter. 
	 * Thus, it can be passed a reference to any instance of that interface, 
	 * including the instance created by a lambda expression.
	 * The second parameter specifies the string to operate on.
	 */
	static String stringOperation(SomeFuncForAgrument sf, String s) {
		return sf.func(s);
	}
	
	public static void main(String args[]) {

		String inStr = "Lambdas add power to Java";
		String outStr;
		System.out.println("Here is input string: " + inStr);
		
		// Here, a simple expression lambda that uppercases a string is passed to stringOp( ).
		outStr = stringOperation((str) -> str.toUpperCase(), inStr);
		System.out.println("The string in uppercase: " + outStr);
		
		// This passes a block lambda that removes spaces.
		outStr = stringOperation((str) -> {
			String result = "";
			int i;
			for (i = 0; i < str.length(); i++)
				if (str.charAt(i) != ' ')
					result += str.charAt(i);
			return result;
		}, inStr);
		
		System.out.println("The string with spaces removed: " + outStr);
		
		/* 
		 * Of course, it is also possible to pass a SomeFuncForAgrument instance created by an earlier lambda expression. 
		 * For example, after this declaration executes, reverse refers to an instance of SomeFuncForAgrument.
		 */ 
		SomeFuncForAgrument reverse = (str) -> {
			String result = "";
			int i;
			for (i = str.length() - 1; i >= 0; i--)
				result += str.charAt(i);
			return result;
		};
		
		/*
		 * Now, reverse can be passed as the first parameter to stringOp()
		 * since it refers to a SomeFuncForAgrument object.
		 */
		System.out.println("The string reversed: " + stringOperation(reverse, inStr));
	}
}

interface SomeFuncForAgrument {
	String func(String n);
}
