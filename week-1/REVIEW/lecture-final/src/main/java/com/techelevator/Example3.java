package com.techelevator;

public class Example3 {

    /*
     1. Given an age, return "Adult", "Child" or "Teen". Teens are ages 13-17 and children are under 13.
     ageGroup(18) → "Adult"
     ageGroup(13) → "Teen"
     ageGroup(12) → "Child"
    */
    public String ageGroup(int age) {
        if(age >= 18){
            return "Adult";
        } else if(age >= 13) {
            return "Teen";
        } else {
            return "Child";
        }
    }

    /*
     2. You have a green lottery ticket, with ints a, b, and c on it. If the numbers are all different from each other,
     the result is 0. If all of the numbers are the same, the result is 20. If two of the numbers are the same, the
     result is 10.
     greenTicket(1, 2, 3) → 0
     greenTicket(2, 2, 2) → 20
     greenTicket(1, 1, 2) → 10
    */
    public int greenTicket(int a, int b, int c) {
        int winnings = 0;
        // check if all the same
        if(a == b && b == c){
            // if they are, return 20
            winnings = 20;
        } else if(a == b || a == c || b == c) {
            // check to see any of the numbers are duplicated
            // then return 10
            winnings = 10;
        } else {
            // return 0
            winnings = 0;
        }

        return winnings;
    }

    /*
     3. Given 2 int values greater than 0, return whichever value is nearest to 21 without going over.
     Return 0 if they both go over.
     blackjack(19, 21) → 21
     blackjack(21, 19) → 21
     blackjack(19, 22) → 19
    */
    public int blackjack(int a, int b) {
        int winningHand = 0;
        if(a > 21 && b > 21){
            winningHand = 0;
        } else if(a > 21) {
            winningHand =  b;
        } else if(b > 21) {
            winningHand =  a;
        } else if(a > b) {
            winningHand =  a;
        } else {
            winningHand =  b;
        }
        return winningHand;
    }

}
