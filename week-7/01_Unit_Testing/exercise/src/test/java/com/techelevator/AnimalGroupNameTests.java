package com.techelevator;

import org.junit.Test;

public class AnimalGroupNameTests {
    /*
     * Given the name of an animal, returns the name of a group of that animal
     * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
     *
     * The animal name should be case insensitive so "elephant", "Elephant", and
     * "ELEPHANT" should all return "herd".
     *
     * If the name of the animal is not found, null, or empty, return "unknown".
     *
     * Rhino -> Crash
     * Giraffe -> Tower
     * Elephant -> Herd
     * Lion -> Pride
     * Crow -> Murder
     * Pigeon -> Kit
     * Flamingo -> Pat
     * Deer -> Herd
     * Dog -> Pack
     * Crocodile -> Float
     *
     * animalGroupName("giraffe") → "Tower"
     * animalGroupName("") -> "unknown"
     * animalGroupName("walrus") -> "unknown"
     * animalGroupName("Rhino") -> "Crash"
     * animalGroupName("rhino") -> "Crash"
     * animalGroupName("elephants") -> "unknown"
     *
     */

    @Test
    public void main() {

        AnimalGroupName test = new AnimalGroupName();

        System.out.println(test.getHerd("giraffe"));// "Tower"
        System.out.println(test.getHerd("")); // "unknown"
        System.out.println(test.getHerd("walrus")); // "unknown"
        System.out.println(test.getHerd("Rhino")); // "Crash"
        System.out.println(test.getHerd("rhino")); // "Crash"
        System.out.println(test.getHerd("elephants")); // "unknown"

    }
}
