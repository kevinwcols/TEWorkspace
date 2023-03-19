package com.techelevator;

public class Airplane {

    // define the attributes for the class
    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int availableFirstClassSeats ;
    private int totalCoachSeats;
    private int bookedCoachSeats;
    private int availableCoachSeats;

    // define the constructor for the class
    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
    }

    //   define the getters and setters for the Airplane class
    public String getPlaneNumber() { return planeNumber; }

    public int getTotalFirstClassSeats() { return totalFirstClassSeats; }

    public int getBookedFirstClassSeats() { return bookedFirstClassSeats; }

    // availableFirstClassSeats is a derived value calculated by subtracting bookedFirstClassSeats from totalFirstClassSeats.
    public int getAvailableFirstClassSeats() {
        // availableFirstClassSeats = totalFirstClassSeats - bookedFirstClassSeats;
        return totalFirstClassSeats - bookedFirstClassSeats;
    }

    public int getTotalCoachSeats() { return totalCoachSeats; }

    public int getBookedCoachSeats() { return bookedCoachSeats; }

    // availableCoachSeats is a derived value calculated by subtracting bookedCoachSeats from totalCoachSeats.
    public int getAvailableCoachSeats() {
       // availableCoachSeats = totalCoachSeats - bookedCoachSeats;
        return totalCoachSeats - bookedCoachSeats;
    }

    // method
    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
        // calculate booked seats
        if ( forFirstClass ) {
               if ( totalNumberOfSeats <= getAvailableFirstClassSeats() ) {
                   bookedFirstClassSeats = totalNumberOfSeats + bookedFirstClassSeats;
                   return true;
               }
       } else if ( totalNumberOfSeats <= getAvailableCoachSeats() ) {
           bookedCoachSeats = totalNumberOfSeats + bookedCoachSeats;
           return true;
       }
       return false;
    }

}
