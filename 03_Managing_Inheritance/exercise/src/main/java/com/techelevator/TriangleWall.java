package com.techelevator;

public class TriangleWall extends Wall{

    private int base;
    private int height;
    /**
     * @param name
     * @param color
     * @param base
     * @param height
     */
    public TriangleWall(String name, String color, int base, int height) {
        super(name, color);
        this.base = base;
        this.height = height;
    }
    @Override
    public int getArea() {
        return (int)((double)base*height)/2;
    }
    @Override
    public String toString() {
        return super.getName()+" ("+base+"x"+height+") triangle";

    }
    /**
     * @return the base
     */
    public int getBase() {
        return base;
    }
    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

}
