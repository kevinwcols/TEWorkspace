package com.techelevator;

import org.junit.Test;

public class FrontTimesTest {
    /*
     * Given a string and a non-negative int n, we'll say that the front of the
     * string is the first 3 chars, or whatever is there if the string is less than
     * length 3. Return n copies of the front; frontTimes("Chocolate", 2) →
     * "ChoCho" frontTimes("Chocolate", 3) → "ChoChoCho" frontTimes("Abc", 3) →
     * "AbcAbcAbc"
     */
    @Test
    public void main() {

        FrontTimes test = new FrontTimes();

        System.out.println(test.generateString("Chocolate", 2));
        System.out.println(test.generateString("Chocolate", 3));
        System.out.println(test.generateString("Abc", 3));
    }

}
