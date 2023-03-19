package com.techelevator;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private final Scanner keyboard = new Scanner(System.in);
    private FileFunctions worker;
    private int maxLines = 0;

    public void start() {
        boolean gotFile = false;
        do {

            try{
                String userInput = askForUserInput("Where is the input file (please include the path to the file)? ");
                worker = new FileFunctions(userInput);
                gotFile = true;
            } catch(FileNotFoundException f) {
                System.out.println("Sorry, Dave, I can't do that. I didn't find the file");
            } catch(Exception e) {
                System.out.println("I don't know what happened!");
            }
        } while(!gotFile);

        do {
            String userInput = askForUserInput("How many lines of text (max) should there be in the split files? ");
            try {
                maxLines = Integer.parseInt(userInput);
            } catch (Exception e) {
                System.out.println("Please enter a whole positive number.");
            }
        } while (maxLines <= 0);

        processFile();
    }

    public void processFile() {
        try {
            int linesInput = worker.linesInFile();
            System.out.println("The input file has " + linesInput + " lines of text.");
            System.out.println();
            System.out.println("Each file that is created must have a sequential number assigned to it.");
            System.out.println();
            int numberOfFiles = (int)Math.ceil((double)linesInput / maxLines);
            System.out.println("For a " + linesInput + " line input file \"" + worker.getName() + "\", this produces " + numberOfFiles + " output files.");
            System.out.println();
            System.out.println("**GENERATING OUTPUT**");
            System.out.println();
            List<String> listOutput = worker.createFiles(maxLines);
            for(String item : listOutput) {
                System.out.println(item);
            }

        } catch (Exception e) {

        }
    }

    private String askForUserInput(String message) {
        System.out.print(message);
        return keyboard.nextLine();
    }
}
