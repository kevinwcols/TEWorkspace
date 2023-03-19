package com.techelevator;

import org.junit.Test;

public class StringBitsTest {
    /*
     * Given a string, return a new string made of every other char starting with
     * the first, so "Hello" yields "Hlo". GetBits("Hello") → "Hlo" GetBits("Hi")
     * → "H" GetBits("Heeololeo") → "Hello"
     */

    @Test
    public static void main(String[] args) {
        System.out.println(StringBits.getBits("Hello"));
        System.out.println(StringBits.getBits("Hi"));
        System.out.println(StringBits.getBits("Heeololeo"));
    }

}
