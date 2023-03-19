package com.techelevator;

import org.junit.Test;

public class Lucky13Test {
    /*
     * Given an array of ints, return true if the array contains no 1's and no 3's.
     * GetLucky([0, 2, 4]) → true GetLucky([1, 2, 3]) → false GetLucky([1, 2,
     * 4]) → false
     */
    @Test
    public static void main(String[] args) {

        Lucky13Test test = new Lucky13Test();

        System.out.println(test.lucky13(new int[]{0, 2, 4}));  // true
        System.out.println(test.lucky13(new int[]{1, 2, 3}));  // false
        System.out.println(test.lucky13(new int[]{1, 2, 4}));  // false
    }

    public boolean lucky13(int[] nums) {
        for(int num : nums){
            if(num == 1 || num == 3) return false;
        }
        return true;
    }
}
