package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("Enter a temperature: ");
		double temp = s.nextDouble();

		System.out.println("Is that Fahrenheit (F) or Celsius (C)? ");
		char choiceForC = s.next().charAt(0);

		if(choiceForC == 'F') {
			System.out.println(temp + " degrees Fahrenheit is " + Math. round(((1.8) * (temp-32)) * 100.0) / 100.0 + " degrees Celsius");
		} else {
			System.out.println(temp + " degrees Celsius is " + Math. round(((1.8) + 32) * 100.0) / 100.0 + " degrees Fahrenheit");
		}
	}

}
