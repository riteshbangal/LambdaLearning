package edu.java.completereference.methodreferences;

/**
 * Demonstrate a method reference for a static method.
 * 		A method reference provides a way to refer to a method without executing it. 
 * 		It relates to lambda expressions,
 * 		because it too requires a target type context that consists of a compatible functional interface.
 * 
 * Method References to static Methods. 
 * To create a static method reference, use this general syntax:
 * 				--> ClassName::methodName
 * 
 * @author - Ritesh
 * @version 1.0
 * @since <07-July-2017>
 */
class MethodRefDemo {

	/*
	 * This method has a functional interface as the type of its first parameter. 
	 * Thus, it can be passed any instance of that interface, including a method reference.
	 */
	static String stringOp(StringFunc sf, String s) {
		return sf.func(s);
	}

	public static void main(String args[]) {
		String inStr = "Lambdas add power to Java";
		
		// Here, a method reference to strReverse is passed to stringOp(). Equivalent to following LOC.
		String outStr = stringOp(MyStringOps::strReverse, inStr);
		
		// Here, directly calling strReverse method as we did with java 7
		String oldOutStr = MyStringOps.strReverse(inStr);
		
		System.out.println("Original string: " + inStr);
		System.out.println("String reversed (Java-8): " + outStr);
		System.out.println("String reversed (Java-7): " + oldOutStr);
	}
}

/*
 * A functional interface for string operations.
 */
interface StringFunc {
	String func(String n);
}

/*
 * This class defines a static method called strReverse().
 */
class MyStringOps {
	
	// A static method that reverses a string.
	static String strReverse(String str) {
		String result = "";
		int i;
		for (i = str.length() - 1; i >= 0; i--)
			result += str.charAt(i);
		return result;
	}
}