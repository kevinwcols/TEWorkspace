package com.techelevator;

import junit.framework.TestCase;
import org.junit.*;
import java.util.Arrays;

/*
     Given an array of ints length 3, figure out which is larger between the first and last elements
     in the array, and set all the other elements to be that value. Return the changed array.
     MakeArray([1, 2, 3]) → [3, 3, 3]
     MakeArray([11, 5, 9]) → [11, 11, 11]
     MakeArray([2, 11, 3]) → [3, 3, 3]
 */

public class MaxEnd3Test {

    TestCase Assertions;

    @Test
    public void testFirstIsBigger() {
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int res[] = maxEnd3.makeArray(new int[]{11,5,9});
        Assertions.assertEquals(11,res[0]);
        System.out.println(Arrays.toString(res));
    }
    @Test
    public void testLastIsBigger() {
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int res[] = maxEnd3.makeArray(new int[]{1, 2, 3});
        Assertions.assertEquals(3,res[2]);
        System.out.println(Arrays.toString(res));
    }
    @Test
    public void testLastIsBigger2() {
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int res[] = maxEnd3.makeArray(new int[]{2, 11, 3});
        Assertions.assertEquals(3,res[2]);
        System.out.println(Arrays.toString(res));
    }

}
