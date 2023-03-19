package com.techelevator;

public class Example1 {

	public static void main(String[] args) {

		/*
		0. Write a constant variable definition for pi, and assign it a value of 3.14.
		 */
		final double PI = 3.14;

		/*
		1. What is 5 divided by 2?
		*/
		System.out.println(5 / 2);
		int firstNumber = 7;
		int secondNumber = 2;

		System.out.println(firstNumber / secondNumber);
		/*
		2. What is 5.0 divided by 2? (Or 5 divided by 2.0?)
		*/
		System.out.println(5.0 / 2);

		/*
		3. What is 66.6 divided by 100?
		*/
		System.out.println(66.6 / 100);

		/*
		4. If I divide 5 by 2, what's my remainder?
		*/
		System.out.println(5 % 2);

		/*
		5. What is 1,000,000,000 * 3?
		*/
		int bigNumber = 1_000_000_000;
		double result = bigNumber * 3.0;
		System.out.println(result);

		long bigLongNumber = 1_000_000_000;
		System.out.println(bigLongNumber * 3);
		
	}
}
