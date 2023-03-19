package com.lendingcatalog.util;

import com.lendingcatalog.util.exception.FileStorageException;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FileStorageService {

    // Requirement: File I/O
    public static void writeContentsToFile(String contents, String filename, boolean appendFile) throws FileStorageException {

        // Get Date/Time for log file
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date dateLogFile = new Date();

        if ( !appendFile) {
            File dataFile = new File(filename);
        }

        try {
            File file = new File("src/main/resources/logs/"+filename);
            if(!file.exists()){
                file.createNewFile();
            }
            // open the file with a FileOutputStream first to append using PrintWriter
            PrintWriter dataOutput = new PrintWriter( new FileOutputStream(file, true) );
            //This will add a new line to the file content
            dataOutput.println("Date/Time: " + dateFormat.format(dateLogFile) + " Contents: " + contents);

            dataOutput.close();

            // System.out.println("Data successfully appended at the end of file");

        } catch ( IOException ioe ) {
            System.out.println("Exception occurred:");
            ioe.printStackTrace();
        }
    }


    public static List<String> readContentsOfFile(String filename) throws FileStorageException {

        try ( //Creating the File object
              InputStream inputStream = new FileInputStream(filename);
              //Creating a Scanner object
              Scanner sc = new Scanner(inputStream);
        ) {
              List<String> fileContents = new ArrayList<>();
            //Appending each line to the buffer
            while (sc.hasNext()) {
                String fList = sc.nextLine();
                fileContents.add(fList);
            }
            return fileContents;
        } catch (IOException ioe) {
            System.out.println("Exception occurred:");
            ioe.printStackTrace();
        }

        return null;
    }

}
