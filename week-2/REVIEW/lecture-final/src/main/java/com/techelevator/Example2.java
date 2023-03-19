package com.techelevator;

import java.util.Locale;

public class Example2 {

    /*
	 1. Given a string, return true if the first and last characters of the string are the letter o (upper or
	 lower case). Ignore any leading or trailing spaces.

	 roundOnBothEnds("Ohio") → true
	 roundOnBothEnds("    OREO ") → true
	 roundOnBothEnds("ooooo!") → false
	*/
    public boolean roundOnBothEnds(String input) {

        String noSpace = input.replace(" ","");

        if(noSpace.toLowerCase().startsWith("o") && noSpace.toLowerCase().endsWith("o")) {
            return true;
        }
        return false;
    }

    /*
	 2. Given two strings, append them together (known as "concatenation") and return the result.
	 However, if the concatenation creates a double-char, then omit one of the chars, so "abc" and
	 "cat" yields "abcat".

	 conCat("abc", "cat") → "abcat"
	 conCat("dog", "cat") → "dogcat"
	 conCat("abc", "") → "abc"
	*/
    public String conCat(String a, String b) {
        String result = a + b;
        if(a.length() > 0 && b.length() > 0)
        {
            String aLast = a.toLowerCase().substring(a.length()-1);
            String bFirst = b.toLowerCase().substring(0,1);
            if(bFirst.equals(aLast)){
                result = a + b.substring(1);
            }
        }


        return result;
    }

    /*
     3. Given a string, return true if the number of appearances of "is" anywhere in the string is equal to
     the number of appearances of "not" anywhere in the string (case sensitive).

     equalIsNot("This is not") → false
     equalIsNot("This is notnot") → true
     equalIsNot("noisxxnotyynotxisi") → true
    */
    public boolean equalIsNot(String str) {
        // count the number of is
        int numberOfIs = 0;
        int numberOfNot = 0;
        // for loop for the is
        for(int i =0;i <str.length()-1;i+=1) {
            if(str.substring(i,i+2).equals("is")){
                numberOfIs++;
            }
        }
        // for loop for the not
        for(int i =0;i <str.length()-2;i+=1) {
            if(str.substring(i,i+3).equals("not")){
                numberOfNot++;
            }
        }
        // count the number of not

        // if number of is == number of not, return true
        return numberOfIs == numberOfNot;
    }

}
