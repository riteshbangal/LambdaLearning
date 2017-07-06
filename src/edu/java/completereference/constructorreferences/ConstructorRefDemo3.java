package edu.java.completereference.constructorreferences;

/**
 * Implement a simple class factory using a constructor reference.
 * 
 * @author - Ritesh
 * @version 1.0
 * @since <07-July-2017>
 */
class ConstructorRefDemo3 {

	/*
	 * A factory method for class objects. The class must have a constructor that takes one parameter of type T.
	 * R specifies the type of object being created.
	 */
	static <R, T> R myClassFactory(MyFunc3<R, T> cons, T v) {
		return cons.func(v);
	}

	public static void main(String args[]) {
		/*
		 * Create a reference to a MyClass constructor.
		 * In this case, new refers to the constructor that takes an argument.
		 */
		MyFunc3<MyClass3<Double>, Double> myClassCons = MyClass3<Double>::new;
		
		// Create an instance of MyClass by use of the factory method.
		MyClass3<Double> mc = myClassFactory(myClassCons, 100.1);
		
		// Use the instance of MyClass just created.
		System.out.println("val in mc is " + mc.getVal());
		
		// Now, create a different class by use of myClassFactory().
		MyFunc3<MyClass2, String> myClassCons2 = MyClass2::new;
		
		// Create an instance of MyClass2 by use of the factory method.
		MyClass2 mc2 = myClassFactory(myClassCons2, "Lambda");
		
		// Use the instance of MyClass just created.
		System.out.println("str in mc2 is " + mc2.getVal());
	}
}

interface MyFunc3<R, T> {
	R func(T n);
}

// A simple generic class.
class MyClass3<T> {
	private T val;

	// A constructor that takes an argument.
	MyClass3(T v) {
		val = v;
	}

	// The default constructor. This constructor
	// is NOT used by this program.
	MyClass3() {
		val = null;
	}

	// ...
	T getVal() {
		return val;
	};
}

// A simple, non-generic class.
class MyClass2 {
	String str;

	// A constructor that takes an argument.
	MyClass2(String s) {
		str = s;
	}

	// The default constructor. This
	// constructor is NOT used by this program.
	MyClass2() {
		str = "";
	}

	// ...
	String getVal() {
		return str;
	};
}
