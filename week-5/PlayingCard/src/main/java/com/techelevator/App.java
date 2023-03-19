package com.techelevator;

public class App {
    public static void main(String[] args) {
        Card firstCard = new Card("Diamonds",8);
        Card secondCard = new Card("Clubs", 7, true);

        firstCard.flip();
        firstCard.flip(true);

        System.out.println("The card is the " + firstCard.getRank() + " of " + firstCard.getSuit() + " and it's color is " + firstCard.getColor());

        System.out.println("The card is the " + secondCard.getRank() + " of " + secondCard.getSuit() + " and it's color is " + secondCard.getColor());
    }
}
