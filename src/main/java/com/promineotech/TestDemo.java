package com.promineotech;

import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {
		int sum = a + b;

		if (a > 0 && b > 0) {
			return sum;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");

		}
	}

	public int randomNumberSquared() {
		int sum = getRandomInt() * getRandomInt();
		return sum;
	}

	public int getRandomInt() {
		Random random = new Random();

		return random.nextInt(10) + 1;
	}

	// My own Test
	public int myTest(int first, int second) {
		int sum = first + second;

		if (first < second) {
			return sum;
		} else {
			throw new IllegalArgumentException("The first value is higher than the second value.");
		}
	}

}
