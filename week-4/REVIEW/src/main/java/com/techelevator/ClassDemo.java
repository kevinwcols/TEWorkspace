package com.techelevator;

public class ClassDemo {
    public boolean refactorSimpleIf(boolean dataIn) {
//        if(dataIn) {
//            return true;
//        } else {
//            return false;
//        }
        return dataIn;
    }

    public boolean didTeamAWin(int teamAScore, int teamBScore) {
        return teamAScore > teamBScore;
    }

    public String refactorNestedIf(boolean thing1, boolean thing2) {
//        if(thing1) {
//            if(thing2) {
//                return "both are true";
//            } else {
//                return "not both are true";
//            }
//        } else {
//            return "not both are true";
//        }
        if (thing1 && thing2) {
            return "both are true";
        } else {
            return "not both are true";
        }
    }

    public void copyPasteCode(int input) {
//        if (input % 2 == 0) {
//            System.out.println("It is now even");
//        } else {
//            System.out.println("It is now odd");
//        }
        isItEven(input);
        input--;

//        if (input % 2 == 0) {
//            System.out.println("It is now even");
//        } else {
//            System.out.println("It is now odd");
//        }
        isItEven(input);
        input--;

//        if (input % 2 == 0) {
//            System.out.println("It is now even");
//        } else {
//            System.out.println("It is now odd");
//        }
        isItEven(input);
        input--;

//        if (input % 2 == 0) {
//            System.out.println("It is now even");
//        } else {
//            System.out.println("It is now odd");
//        }
        isItEven(input);
        input--;
    }

    // helper method
    public  String isItEven(int input){
        if(input % 2 == 0) {
            return  "It is even";
        } else {
            return "It is now odd";
        }
    }
}
