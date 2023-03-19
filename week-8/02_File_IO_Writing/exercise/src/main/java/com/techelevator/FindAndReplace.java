package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {
        // create scanner object
        Scanner input = new Scanner(System.in);
        // Read all information from the user
        System.out.println("What is the search word?");
        String search = input.nextLine();
        System.out.println("What is the replacement word?");
        String replacementWord = input.nextLine();
        System.out.println("What is the source file?");
        String source = input.nextLine();
        System.out.println("What is the destination file?");
        String destination = input.nextLine();
        if (destination.isEmpty() || destination == null) {
           System.exit(0);
        }
        input.close();
        try
                (               // create FileWriter object
                        FileWriter fileOut = new FileWriter(destination);
                        // create BufferedWriter object
                        BufferedWriter bw = new BufferedWriter(fileOut);
                        // create scanner object
                        Scanner fileRead = new Scanner(new File(source));) {
            // check next line present or not
            while (fileRead.hasNextLine()) {
                // read each line
                String data = fileRead.nextLine();
                // write data to the destination file
                bw.write(data.replace(search, replacementWord));
                bw.newLine();
            }
            System.out.println("Data replaced successfully.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
