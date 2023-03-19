package com.techelevator;

public class Card {
    // our properties
    private String suit;
    private int rank;
    private boolean faceUp;

    // constructors
    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Card(String suit, int rank, boolean faceUp) {
        this.suit = suit;
        this.rank = rank;
        this.faceUp = faceUp;
    }

    // derived property
    public String getColor() {
        if(suit.equals("Hearts") || suit.equals("Diamonds")) {
            return "Red";
        } else {
            return "Black";
        }
    }
    // getters
    public String getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    // actions which are methods, these are overloaded
    public void flip() {
        if(faceUp) {
            faceUp = false;
        } else {
            faceUp = true;
        }
    }

    public void flip(boolean makeFaceUp) {
        faceUp = makeFaceUp;
    }
}
