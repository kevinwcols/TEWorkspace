package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
			// Create a Scanner object
			Scanner input = new Scanner(System.in);

			// Create constant value for meters to feet conversion
			final double METERS_PER_FOOT = 0.3048;

			// Prompt user to enter a number in feet
			System.out.print("Enter a value for feet: ");
			double feetInput = input.nextDouble();

			// Convert feet into meters
			double feetToMetersConversion = feetInput * METERS_PER_FOOT;

			// Display results of feet into meters conversion
			System.out.println(feetInput + " feet is " + feetToMetersConversion + " meters");

			// Create constant value for feet to meters conversion
			final double FEET_PER_METERS = 3.2808399;

			// Prompt user to enter a number in feet
			System.out.print("Enter a value for meters: ");
			double metersToFeetConversion = input.nextDouble();

			// Convert meters into feet
			double metersInput = metersToFeetConversion * FEET_PER_METERS;

			// Display results of meters into feet conversion
			System.out.println(metersToFeetConversion + " feet is " + metersInput + " meters");
	}

}
