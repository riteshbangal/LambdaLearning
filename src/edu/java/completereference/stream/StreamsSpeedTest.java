package edu.java.completereference.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Example speed test through Stream
 * 
 * @author - Ritesh
 * @version 1.0
 * @since <07-July-2017>
 */
public class StreamsSpeedTest {

	public static void main(String[] args) throws InterruptedException {

		Random random = new Random();
		List<Integer> data = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			data.add(random.nextInt());
		}
		
		
		// Java - 7 Approach
		long startTime = System.currentTimeMillis();
		System.out.println("Starting...");
		int result = 0;
		for (Integer val : data) {
			result += factorial(val);
		}
		System.out.println("Result: " + result);
		long endTime = System.currentTimeMillis();
		long delay = endTime - startTime;
		System.out.println("Delay: " + delay);
		System.out.println("End.");
		
		// Java - 8 Normal Stream Approach
		startTime = System.currentTimeMillis();
		System.out.println("\nStarting...");
		result = data.stream()
			.map(i -> {
				try {
					return factorial(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return i;
			})
			.reduce(Integer::sum)
			.get();
		System.out.println("Result: " + result);
		endTime = System.currentTimeMillis();
		delay = endTime - startTime;
		System.out.println("Delay: " + delay);
		System.out.println("End.");
		
		// Java - 8 Parallel Stream Approach --> It's very very faster
		startTime = System.currentTimeMillis();
		System.out.println("\nStarting...");
		result = data.parallelStream()
			.map(i -> {
				try {
					return factorial(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return i;
			})
			.reduce(Integer::sum)
			.get();
		System.out.println("Result: " + result);
		endTime = System.currentTimeMillis();
		delay = endTime - startTime;
		System.out.println("Delay: " + delay);
		System.out.println("End.");
	}


	public static int factorial(int input) throws InterruptedException {
		Thread.sleep(10);
		return (int) Math.pow(input, 2);
	}
}
