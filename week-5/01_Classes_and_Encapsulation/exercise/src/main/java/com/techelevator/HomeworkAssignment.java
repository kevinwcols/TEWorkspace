package com.techelevator;

public class HomeworkAssignment {

    // define the attributes for the class
    private int earnedMarks;
    private int possibleMarks;
    private String letterGrade;
    private String submitterName;

    // define the constructor for the class
    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

    //   define the getters and setters for the HomeworkAssignment class
    public int getEarnedMarks() {
        return earnedMarks;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getLetterGrade() {
        //   calculate the grade
        double percentage =
                (Double.valueOf(this.earnedMarks) / Double.valueOf(this.possibleMarks)) * 100;
        if (percentage >= 90) {
            // set the grade as A
            this.letterGrade = "A";
        } else if (percentage >= 80) {
            // set the grade as B
            this.letterGrade = "B";
        } else if (percentage >= 70) {
            // set the grade as C
            this.letterGrade = "C";
        } else if (percentage >= 60) {
            // set the grade as D
            this.letterGrade = "D";
        } else {
            this.letterGrade = "F";
        }

        return letterGrade;
    }

    public String getSubmitterName() {
        return submitterName;
    }

}

