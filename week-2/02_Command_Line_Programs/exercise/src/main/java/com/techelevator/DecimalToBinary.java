package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter any number: ");

		int x = in.nextInt();
		// integer
		System.out.println("Integer: "+x);
		// binary
		System.out.println("Binary = " + Integer.toBinaryString(x));
		return;

	}

}
