package com.techelevator;

public class SquareWall extends RectangleWall{

    private int sideLength;

    /**
     * @param name
     * @param color
     * @param length
     * @param height
     * @param sideLength
     */
    public SquareWall(String name, String color, int sideLength) {
        super(name, color, sideLength, sideLength);
        this.sideLength = sideLength;
    }

    @Override
    public String toString() {
//name (sideLengthxsideLength) square
        return super.getName()+" ("+sideLength+"x"+sideLength+") square";
    }

    /**
     * @return the sideLength
     */
    public int getSideLength() {
        return sideLength;
    }

}
