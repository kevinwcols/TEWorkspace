package com.lendingcatalog.model;

public class Member {
    String firstName;
    String lastName;

    // Constructor
    public Member(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // methods
    public String toString () {
        return "Member Name: " + firstName + ' ' +  lastName+ System.lineSeparator();
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
