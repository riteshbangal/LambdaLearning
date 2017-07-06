package edu.java.completereference.stream;

import java.util.Arrays;
import java.util.List;

import edu.java.completereference.stream.PersonBean.Gender;

/**
 * Example of Stream from baralaborn
 * 
 * @author - Ritesh
 * @version 1.0
 * @since <07-July-2017>
 */
public class StreamsDemoFirst {

	public static void main(String[] args) {
		
		List<PersonBean> persons = Arrays.asList(
				new PersonBean("Ritesh Bangal", 29, Gender.MALE), 
				new PersonBean("Triyanka Gupta", 28, Gender.FEMALE),
				new PersonBean("Shukla Bangal", 24, Gender.FEMALE), 
				new PersonBean("Andrew Watson", 20, Gender.MALE),
				new PersonBean("Leema Mathew", 35, Gender.FEMALE)
			);
		
		persons.stream()
			.filter(p -> p.gender.equals(Gender.FEMALE))
			.sorted(PersonBean::compareFirstName)
			.map(p -> p.firstName + " " + p.lastName)
			.forEach(p -> System.out.println(p.toString())
		);
	}
}


class PersonBean {
	
	String firstName;
	String lastName;
	int age;
	Gender gender;
	
	public PersonBean() {
		// Default constructor
	}
	
	public PersonBean(String firstName, String lastName, int age, Gender gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
	}
	
	public PersonBean(String name, int age, Gender gender) {
		this.firstName = name.split(" ")[0];
		this.lastName = name.split(" ")[1];
		this.age = age;
		this.gender = gender;
	}
	
	public static int compareFirstName(PersonBean p1, PersonBean p2) {
		return p1.firstName.compareTo(p2.firstName);
	}
	
	public static int compareLastName(PersonBean p1, PersonBean p2) {
		return p1.lastName.compareTo(p2.lastName);
	}
	
	public static int compareAge(PersonBean p1, PersonBean p2) {
		return Integer.compare(p1.age, p2.age);
	}
	
	public static int compareGender(PersonBean p1, PersonBean p2) {
		return p1.gender == p2.gender ? 0 : p1.gender == Gender.MALE ? 1 : -1;
	}
	
	@Override
	public String toString() {
		StringBuilder person = new StringBuilder();
		person.append("[firstName: ").append(firstName)
			.append(", lastName: ").append(lastName)
			.append(", age: ").append(age)
			.append(", gender: ").append(gender)
			.append("]");
		return person.toString();
	}
	
	public static enum Gender {
		MALE, FEMALE;
	}
}