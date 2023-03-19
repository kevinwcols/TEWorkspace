package com.techelevator;

public class Exercise01_TestGrading {


    int gradeTestPassFail90 = 90;
    int gradeTestPassFail70 = 70;
    int gradeTestPassFail45 = 45;

    int intGrade90orHigher = 90;
    int intGrade50orHigher = 50;
    int intGrade25orHigher = 25;
    int intGrade24orLower = 24;

    int intGrade90orHigherReturn = 3;
    int intGrade50orHigherReturn = 2;
    int intGrade25orHigherReturn = 1;
    int intGrade24orLowerReturn = 0;
    /*
    Grade-o-matic Incorporated has a program to grade student tests.
    The problems below ask you to implement the logic for returning a grade based on a student's test score.
     */

    /*
    Grade-o-matic v1.0 scores tests as pass-fail.
    A score of 70 or higher is a passing score. Anything lower is a failing score.
    Return true for a passing score and false for a failing score.

    Examples:
    gradeTestPassFail(90) ➔ true
    gradeTestPassFail(70) ➔ true
    gradeTestPassFail(45) ➔ false
     */

    public boolean gradeTestPassFail(int score) {
        if ( score >= gradeTestPassFail90 ) {
            return true;
        }
        else if ( score >= gradeTestPassFail70 ) {
            return true;
        }
        else if ( score <= gradeTestPassFail45 ) {
            return false;
        }
        return false;
    }

    /*
    Grade-o-matic received numerous requests from customers to grade using a point-based system.
    Grade-o-matic v2.0 can now also score tests on a 0-3 scale.
    Implement the logic to grade tests using this new scale:
        For a score of 90 or higher, return 3
        For a score of 50-89, return 2
        For a score of 25-49, return 1
        For a score of less than 25, return 0

    Examples:
    gradeTestNumeric(90) ➔ 3
    gradeTestNumeric(70) ➔ 2
    gradeTestNumeric(45) ➔ 1
    gradeTestNumeric(10) ➔ 0
     */

    public int gradeTestNumeric(int score) {
        if ( score >= intGrade90orHigher ) {
            return intGrade90orHigherReturn;
        }
        else if ( score >= intGrade50orHigher ) {
            return intGrade50orHigherReturn;
        }
        else if ( score >= intGrade25orHigher ) {
            return intGrade25orHigherReturn;
        }
        else {
            return intGrade24orLowerReturn;
        }
    }

    /*
    Grade-o-matic has received even more requests to grade using the classic letter scale.
    Grade-o-matic v3.0 can now score tests on a letter scale.
    Implement the logic to grade tests using this new scale:
        For a score of 90 or higher, return 'A'
        For a score of 80-89, return 'B'
        For a score of 70-79, return 'C'
        For a score of 60-69, return 'D'
        For a score less than 60, return 'F'

    Examples:
    gradeTestLetter(90) ➔ 'A'
    gradeTestLetter(70) ➔ 'C'
    gradeTestLetter(45) ➔ 'F'
     */
    char gradeTestLetter90 = 'A';
    char gradeTestLetter80 = 'B';
    char gradeTestLetter70 = 'C';
    char gradeTestLetter60 = 'D';
    char gradeTestLetter59 = 'F';

    int gradeTestScore90 = 90;
    int gradeTestScore80 = 80;
    int gradeTestScore70 = 70;
    int gradeTestScore60 = 60;
    int gradeTestScore59 = 590;

    public char gradeTestLetter(int score) {
        if ( score >= gradeTestScore90 ) {
            return gradeTestLetter90;
        }
        else if ( score >= gradeTestScore80 ) {
            return gradeTestLetter80;
        }
        else if ( score >= gradeTestScore70 ) {
            return gradeTestLetter70;
        }
        else if ( score >= gradeTestScore60 ) {
            return gradeTestLetter60;
        }
        else if ( score <= gradeTestScore59 ) {
            return gradeTestLetter59;
        }
        return ' ';
    }
}
