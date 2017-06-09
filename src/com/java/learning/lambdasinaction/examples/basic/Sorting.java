package com.java.learning.lambdasinaction.examples.basic;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sorting {

	public static void main(String... args) {

		// Initializing inventory list
		List<Apple> inventory = new ArrayList<>();
		inventory.addAll(Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red")));

		// Approach 1: Creating customize comparator.  
		// [Apple{color='green', weight=80}, Apple{color='red', weight=120}, Apple{color='green', weight=155}]
		inventory.sort(new AppleComparator());
		System.out.println(inventory);

		// reshuffling things a little
		inventory.set(1, new Apple(30, "green"));

		// Approach 2: Creating anonymous inner class
		// [Apple{color='green', weight=30}, Apple{color='green', weight=80}, Apple{color='green', weight=155}]
		inventory.sort(new Comparator<Apple>() {
			@Override
			public int compare(Apple a1, Apple a2) {
				return a1.getWeight().compareTo(a2.getWeight());
			}
		});
		System.out.println(inventory);

		// reshuffling things a little
		inventory.set(1, new Apple(20, "red"));

		// Approach 3: Creating lambda expression
		// [Apple{color='red', weight=20}, Apple{color='green', weight=30}, Apple{color='green', weight=155}]
		inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
		System.out.println(inventory);

		// reshuffling things a little
		inventory.set(1, new Apple(10, "red"));

		// Approach 4: Using OOTB method and pass lambda expression as argument 
		/*
		 * Accepts a function that extracts a Comparable sort key from a type T, 
		 * and returns a Comparator<T> that compares by that sort key. 
		 * @FunctionalInterface
		 */
		// [Apple{color='red', weight=10}, Apple{color='red', weight=20}, Apple{color='green', weight=155}]
		inventory.sort(comparing(Apple::getWeight));
		System.out.println(inventory);
	}

	public static class Apple {
		private Integer weight = 0;
		private String color = "";

		public Apple(Integer weight, String color) {
			this.weight = weight;
			this.color = color;
		}

		public Integer getWeight() {
			return weight;
		}

		public void setWeight(Integer weight) {
			this.weight = weight;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String toString() {
			return "Apple{" + "color='" + color + '\'' + ", weight=" + weight + '}';
		}
	}

	static class AppleComparator implements Comparator<Apple> {
		public int compare(Apple a1, Apple a2) {
			return a1.getWeight().compareTo(a2.getWeight());
		}
	}
}