package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Exercises {
    public int findMaxValue(int[] numbers) {
        try {
            int currentHighNumber = numbers[0];
            for (int item : numbers) {
                if (currentHighNumber < item) {
                    currentHighNumber = item;
                }
            }
            return currentHighNumber;
        } catch (NullPointerException n) {
            throw n;
        } catch (IndexOutOfBoundsException i) {
            return 0;
        } catch(IllegalArgumentException iae) {
            return -1;
        }

    }

}
