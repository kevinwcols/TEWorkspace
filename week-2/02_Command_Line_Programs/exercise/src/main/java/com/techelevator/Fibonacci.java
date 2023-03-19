package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		int n;
		int a = 0;
		int b = 1;

		Scanner s = new Scanner(System.in);

		System.out.print("Enter a number to compute the Fibonacci: ");
		n = s.nextInt();
		System.out.print("Fibonacci Series: ");
		if ( n <= 0 ) {
			System.out.print("0 1");
		}
		else if ( n == 1 ) {
			System.out.print("0 1 ");
		}
		else {
			System.out.print("0 1 ");
		}
		for(int i = 1; i <= n; i++)
		{
				a = b;
				b = a + b;
				System.out.print(a + " ");
		}
	}

}
