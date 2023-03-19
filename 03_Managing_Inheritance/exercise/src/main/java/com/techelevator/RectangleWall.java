package com.techelevator;

public class RectangleWall extends Wall {

    private int length;
    private int height;
    /**
     * @param name
     * @param color
     * @param length
     * @param height
     */
    public RectangleWall(String name, String color, int length, int height) {
        super(name, color);
        this.length = length;
        this.height = height;
    }
    @Override
    public int getArea() {
        return length*height;
    }
    @Override
    public String toString() {
//name (lengthxheight) rectangle
        return super.getName()+" ("+length+"x"+height+") rectangle";
    }
    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }
    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

}
