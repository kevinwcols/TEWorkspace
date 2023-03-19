package com.techelevator;

public class Elevator {
    // define the attributes for the class
    private int currentFloor = 1;
    private int numberOfFloors;
    private boolean doorOpen;

    // define getters, no setters are needed
    public int getCurrentFloor() { return currentFloor; }

    public int getNumberOfFloors() { return numberOfFloors; }

    public boolean getDoorOpen() { return doorOpen; }

    // define the constructor for the class
    public Elevator(int numberOfLevels) {
        this.numberOfFloors = numberOfLevels;
    }

    // methods

    public boolean isDoorOpen() {
        if ( doorOpen == true ) {
            return true;
        }
        return false;
}

    public void openDoor() {
        doorOpen = true;
    }

    public void closeDoor() {
        doorOpen = false;
    }

    public void goUp(int desiredFloor) {
        if ( doorOpen == false && desiredFloor > currentFloor && desiredFloor <= numberOfFloors ) {
            currentFloor = desiredFloor;
        }
    }

    public void goDown(int desiredFloor) {
        if ( doorOpen == false && desiredFloor >= 1 && desiredFloor < currentFloor ) {
            currentFloor = desiredFloor;
        }
    }

}
