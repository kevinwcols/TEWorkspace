package com.techelevator;

public abstract class Wall {

    private String name;
    private String color;


    /**
     * @param name
     * @param color
     */
    public Wall(String name, String color) {
        super();
        this.name = name;
        this.color = color;
    }

    public abstract int getArea();

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

}
