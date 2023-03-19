package com.techelevator;

import junit.framework.TestCase;
import org.junit.Test;

public class SameFirstLastTest {
    /*
     Given an array of ints, return true if the array is length 1 or more, and the first element and
     the last element are equal.
     IsItTheSame([1, 2, 3]) → false
     IsItTheSame([1, 2, 3, 1]) → true
     IsItTheSame([1, 2, 1]) → true
     */

        TestCase Assertions;

        public static void main(String[] args) {

            SameFirstLastTest test = new SameFirstLastTest();

            System.out.println(test.sameFirstLast(new int[] {1, 2, 3}));
            System.out.println(test.sameFirstLast(new int[] {1, 2, 3, 1}));
            System.out.println(test.sameFirstLast(new int[] {1, 2, 1}));
        }
        @Test
        public boolean sameFirstLast(int[] nums) {
            if (nums.length > 0) {
                return nums[0] == nums[nums.length - 1];
            }
            return false;
        }

        @Test
        public void testWithValid() {
            Assertions.assertEquals(true,new SameFirstLast().isItTheSame(new int[]{1,2,3,1}));
        }

        @Test
        public void testWithInValid() {
            Assertions.assertEquals(false,new SameFirstLast().isItTheSame(new int[]{1,2,3,2}));
        }

    }