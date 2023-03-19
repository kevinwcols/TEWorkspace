package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileFunctions {
    private File originalFile;

    public FileFunctions(String filePath) throws FileNotFoundException {
        originalFile = new File(filePath);
        if(!originalFile.exists() || !originalFile.isFile()) {
            throw new FileNotFoundException("Hey, sorry, I can't locate that file.");
        }
    }

    public String getName() {
        return originalFile.getName();
    }
    public int linesInFile() throws FileNotFoundException {
        int numberOfLines = 0;
        try (Scanner fileReader = new Scanner(originalFile)){

            while(fileReader.hasNextLine()) {
                fileReader.nextLine();
                numberOfLines++;
            }
        } catch (FileNotFoundException e) {
            throw e;
        }
        return numberOfLines;
    }

    public List<String> createFiles(int numberOfOutputLines) {
        List<String> result = new ArrayList<>();
        int fileCounter = 1;
        try(Scanner fileReader = new Scanner(originalFile)) {
            while(fileReader.hasNextLine()) {
                File fileOut = new File("output-" + fileCounter + ".txt");
                try(PrintWriter writer = new PrintWriter(fileOut)) {
                    for(int i = 0; i < numberOfOutputLines && fileReader.hasNextLine(); i++) {
                        writer.println(fileReader.nextLine());
                    }
                    result.add("Generating " + fileOut.getName());
                } catch (FileNotFoundException e) {

                }
                fileCounter++;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
