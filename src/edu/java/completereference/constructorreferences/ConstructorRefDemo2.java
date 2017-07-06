package edu.java.completereference.constructorreferences;

/**
 * Demonstrate a constructor reference with a generic class.
 * 
 * @author - Ritesh
 * @version 1.0
 * @since <07-July-2017>
 */
class ConstructorRefDemo2 {

	public static void main(String[] args) {

		// Create a reference to the MyClass<T> constructor.
		MyFuncGeneric<Integer> myClassCons = MyClassForConstructorRef<Integer>::new;
		
		// Create an instance of MyClass<T> via that constructor reference.
		MyClassForConstructorRef<Integer> mc = myClassCons.func(100);
		
		// Use the instance of MyClass<T> just created.
		System.out.println("val in mc is " + mc.getVal());
	}
}

/*
 * MyFunc is now a generic functional interface.
 */
interface MyFuncGeneric<T> {
	MyClassForConstructorRef<T> func(T n);
}

class MyClassForConstructorRef<T> {
	private T val;

	// A constructor that takes an argument.
	MyClassForConstructorRef(T v) {
		val = v;
	}

	// This is the default constructor.
	MyClassForConstructorRef() {
		val = null;
	}

	// ...
	T getVal() {
		return val;
	}
}
