package edu.java.completereference.lambdaexpressions;

/**
 * Use a generic functional interface with lambda expressions.
 * Instead of having two functional interfaces whose methods differ only in their data types, 
 * it is possible to declare one generic interface that can be used to handle both circumstances. 
 * 
 * The following program shows this approach:
 * 
 * @author - Ritesh
 * @version 1.0
 * @since <08-July-2017>
 */
class GenericFunctionalInterfaceDemo {
	
	public static void main(String args[]) {
		
		// Use a String-based version of SomeFunc.
		SomeFunc<String> reverse = (str) -> {
			String result = "";
			int i;
			for (i = str.length() - 1; i >= 0; i--)
				result += str.charAt(i);
			return result;
		};
		
		System.out.println("Lambda reversed is " + reverse.func("Lambda"));
		System.out.println("Expression reversed is " + reverse.func("Expression"));
		
		// Now, use an Integer-based version of SomeFunc.
		SomeFunc<Integer> factorial = (n) -> {
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
 * A generic functional interface.
 */
interface SomeFunc<T> {
	T func(T t);
}
