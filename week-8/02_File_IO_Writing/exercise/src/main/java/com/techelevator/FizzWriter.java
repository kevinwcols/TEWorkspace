package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args)
	{
		String filename;
		Scanner sc = new Scanner(System.in);

		// input the destination file
		System.out.println("Enter the destination file: ");
		filename = sc.nextLine();

		// create file object
		File dataFile = new File(filename);

		// check if destination file is empty
		if (filename.isEmpty() || filename == null) {
			System.exit(0);
		}

		try ( PrintWriter writer = new PrintWriter(dataFile); ) {
			// create a new file with given filename

			// loop from 1 to 300 lines (inclusive)
			for(int n=1;n<=300;n++)
			{
				if(n%3 == 0 && n%5 == 0) // n is divisible by 3 and 5, output "FizzBuzz" to file
					writer.println("FizzBuzz");
				else if(n%3 == 0 ) // n is divisible by 3 or n contains 3, output "Fizz"
					writer.println("Fizz");
				else if(n%5 == 0 ) // n is divisible by 5 or n contains 5, output "Buzz"
					writer.println("Buzz");
				else // else output n
					writer.println(n);
			}

			writer.close(); // close the file


		} catch (FileNotFoundException  e) {
			// invalid destination file, display error and exit
			System.out.println("Error: Invalid destination file.");
		}
	}

}