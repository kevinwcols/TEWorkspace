package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Exercises {
    public int findMaxValue(int[] numbers) {
        int currentHighNumber = numbers[0];
        for(int item : numbers) {
            if(currentHighNumber < item) {
                currentHighNumber = item;
            }
        }
        return currentHighNumber;
    }

}
