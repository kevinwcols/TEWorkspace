package com.techelevator;

import junit.framework.TestCase;
import org.junit.*;

import java.util.Arrays;

/*
 Given 2 strings, return their concatenation, except omit the first char of each. The strings will
 be at least length 1.
 GetPartialString("Hello", "There") → "ellohere"
 GetPartialString("java", "code") → "avaode"
 GetPartialString("shotl", "java") → "hotlava"
 */

public class NonStartTest {

    public static void main(String[] args) {

        NonStartTest test = new NonStartTest();

        System.out.println(test.nonStart("Hello", "There"));
        System.out.println(test.nonStart("java", "code"));
        System.out.println(test.nonStart("shotl", "java"));
    }

    @Test
    public String nonStart(String a, String b) {
        return a.substring(1) + b.substring(1);
    }

}