package com.techelevator;

public class FruitTree {

    // define the attributes for the class
    private String typeOfFruit;
    private int piecesOfFruitLeft;

    // define the constructor for the class
    public FruitTree(String typeOfFruit, int piecesOfFruitLeft) {
        this.typeOfFruit = typeOfFruit;
        this.piecesOfFruitLeft = piecesOfFruitLeft;
    }

    //   define the getters and setters for the FruitTree class
    public String getTypeOfFruit() { return typeOfFruit; }

    public int getPiecesOfFruitLeft() { return piecesOfFruitLeft; }

    // method
    public boolean pickFruit(int numberOfPiecesToRemove) {
        // calculate if there's enough pieces of fruit left on tree to pick and return boolean value
        boolean enoughFruitLeft = false;
        if ( numberOfPiecesToRemove <= piecesOfFruitLeft ) {
            piecesOfFruitLeft = piecesOfFruitLeft - numberOfPiecesToRemove;
            enoughFruitLeft = true;
        }
        return enoughFruitLeft;
    }
}
