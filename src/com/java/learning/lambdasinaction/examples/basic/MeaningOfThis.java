package com.java.learning.lambdasinaction.examples.basic;

public class MeaningOfThis {
	public final int value = 4;

	public void doIt() {
		int value = 6;
		System.out.println(value);
		Runnable r = new Runnable() {
			public final int value = 5;

			public void run() {
				int value = 10;
				System.out.println(value);
				System.out.println(this.value);
			}
		};
		r.run();

		Runnable lambdaThresd = () -> System.out.println(value);
		lambdaThresd.run();
	}

	public static void main(String... args) {
		MeaningOfThis m = new MeaningOfThis();
		m.doIt(); // ???
	}
}