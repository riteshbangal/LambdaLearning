package edu.java.completereference.methodreferences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Use a method reference to help find the maximum value in a collection.
 * 
 * @author - Ritesh
 * @version 1.0
 * @since <07-July-2017>
 */
class UseMethodRef {

	// A compare() method compatible with the one defined by Comparator<T>.
	static int compareMC(MyClass a, MyClass b) {
		return a.getVal() - b.getVal();
	}

	public static void main(String args[]) {
		ArrayList<MyClass> al = new ArrayList<MyClass>();
		al.add(new MyClass(1));
		al.add(new MyClass(4));
		al.add(new MyClass(2));
		al.add(new MyClass(9));
		al.add(new MyClass(3));
		al.add(new MyClass(7));
		
		// Find the maximum value in al using the compareMC() method. java-8
		MyClass maxValObjNew = Collections.max(al, UseMethodRef::compareMC);
		System.out.println("Maximum value is (Java-8): " + maxValObjNew.getVal());
		/*
		 * Note:
		 * Signature: public static <T> T max(Collection<? extends T> coll, Comparator<? super T> comp) {
		 *  
		 * In the program, notice that MyClass neither defines any comparison method of its own,
		 * nor does it implement Comparator. 
		 * However, the maximum value of a list of MyClass items can still be obtained by calling max( ) 
		 * because UseMethodRef defines the static method compareMC( ), 
		 * which is compatible with the compare( ) method defined by Comparator.
		 * Therefore, there is no need to explicitly implement and create an instance of Comparator.
		 */
		
		// Find the maximum value in al using Comparator implementation. Java-7
		MyClass maxValObjOld = Collections.max(al, new MyComparator());
		System.out.println("Maximum value is (Java-7): " + maxValObjOld.getVal());
	}

}

class MyClass {
	private int val;

	MyClass(int v) {
		val = v;
	}

	int getVal() {
		return val;
	}
}

class MyComparator implements Comparator<MyClass> {
	@Override
	public int compare(MyClass a, MyClass b) {
		return a.getVal() - b.getVal();
	}
	
}