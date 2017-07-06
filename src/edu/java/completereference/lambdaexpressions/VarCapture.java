package edu.java.completereference.lambdaexpressions;

/**
 * An example of capturing a local variable from the enclosing scope. 
 * 		when a lambda expression uses a local variable from its enclosing scope, 
 * 		a special situation is created that is referred to as a variable capture. 
 * 		In this case, a lambda expression may only use local variables that are effectively final. 
 * 		An effectively final variable is one whose value does not change after it is first assigned. 
 *		There is no need to explicitly declare such a variable as final, although doing so would not be an error.
 * 
 * The following program shows this approach:
 * 
 * @author - Ritesh
 * @version 1.0
 * @since <08-July-2017>
 */
class VarCapture {

	public static void main(String args[]) {
		// A local variable that can be captured.
		int num = 10;
		MyFuncForVarCapture myLambda = (n) -> {
			// This use of num is OK. It does not modify num.
			int v = num + n;
			// However, the following is illegal because it attempts to modify the value of num.
			// num++;
			return v;
		};

		// The following line would also cause an error, because it would remove the effectively final status from num.
		//num = 9;
		
		System.out.println("Result: " + myLambda.func(100));
	}
}

interface MyFuncForVarCapture {
	int func(int n);
}
