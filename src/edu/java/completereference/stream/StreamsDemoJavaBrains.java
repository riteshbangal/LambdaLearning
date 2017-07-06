package edu.java.completereference.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Example of Stream from Java-Brains
 * 
 * @author - Ritesh
 * @version 1.0
 * @since <07-July-2017>
 */
public class StreamsDemoJavaBrains {

	public static void main(String[] args) {
		
		List<Person> persons = Arrays.asList(
				new Person("Ritesh", "Bangal", 29), 
				new Person("Triyanka", "Gupta", 28),
				new Person("Shukla", "Bangal", 24), 
				new Person("Andrew", "Watson", 20),
				new Person("Leema", "Mathew", 35)
			);
		
		persons.parallelStream()
			.filter(p -> p.lastName.startsWith("B"))
			.forEach(p -> System.out.println(p.toString()));
		
		System.out.println(persons.stream().isParallel());
		
		// Create lambda expression with Comparator interface
		Comparator<Person> conparatorLambda = (p1, p2) -> Integer.compare(p1.age, p2.age);
		
		System.out.println("-------------------------------------------");
		// Here as it's parallel stream, it wont display as expected
		persons.parallelStream()
				//.sorted((p1, p2) -> Integer.compare(p1.age, p2.age))
				.sorted(conparatorLambda)
				.forEach(p -> System.out.println(p.toString()));

		System.out.println("-------------------------------------------");

		persons.stream()
				.sorted(conparatorLambda)
				.forEach(p -> System.out.println(p.toString()));
	}
}


class Person {
	
	String firstName;
	String lastName;
	int age;
	
	public Person() {
		// Default constructor
	}
	
	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	@Override
	public String toString() {
		StringBuilder people = new StringBuilder();
		people.append("[firstName: ").append(firstName)
			.append(", lastName: ").append(lastName)
			.append(", age: ").append(age)
			.append("]");
		return people.toString();
	}
}