package com.techelevator;

public class Example1 {

    /*
     1. Given a starting number and a higher ending number, return the sum of all the numbers from the
     starting number up to the ending number.

     sumAllNumbers(0, 1) → 1
     sumAllNumbers(2, 6) → 20  (2 + 3 + 4 + 5 + 6 = 20)
     sumAllNumbers(100, 104) → 510
    */
    public int sumAllNumbers(int start, int end) {
        int sum = 0;
        for(int i = start;i <= end;i++) {
            sum += i;
        }
        return sum;
    }

    /*
	 2. Given an array of ints, return true if one of the first 4 elements in the array is a 9.
	 The array length may be less than 4.

	 arrayFront9([1, 9, 2]) → true
	 arrayFront9([1, 2, 3, 4, 9]) → false
	 arrayFront9([1, 2, 3, 4, 5]) → false
	 */
    public boolean arrayFront9(int[] nums) {
        boolean result = false;
        // need to check for valid
        if(nums == null) {
            return result;
        }
        // if length < 4, use the whole array
        int numbersTolookAt = 4;
        if(nums.length < 4) {
            numbersTolookAt = nums.length;
        }

        for(int index = 0;index < numbersTolookAt;index++){
            if(nums[index] == 9) {
                result = true;
            }
        }
        return result;
    }

    /*
	 3. Given an array of integers, return an array of doubles where each element is half the value of the element at the
	 same index in the integer array.

	 halveAll([2, 4, 6, 8]) → [1.0, 2.0, 3.0, 4.0]
	 halveAll([1, 1, 1]) → [0.5, 0.5, 0.5]
	 halveAll([3, 300]) → [1.5, 150.0]
	 */
    public double[] halveAll(int[] input) {
        // need an array of doubles to hold my results
        double[] holder = new double[input.length];
        // go through each element in the array
        for(int i=0;i < input.length;i++) {
            // divide that element by 2
            double halfOfElement = input[i] / 2.0;
            // store that value in the holder array
            holder[i] = halfOfElement;
            // get the next value, and do it again
        }

        // return holder array
        return holder;
    }

}
