package com.techelevator;

import java.util.*;

import org.junit.Test;

public class WordCountTest {
    /*
     * Given an array of strings, return a Map<String, Integer> with a key for
     * each different string, with the value the number of times that string appears
     * in the array.
     *
     * ** A CLASSIC **
     *
     * getCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
     * getCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}
     * getCount([]) → {}
     * getCount(["c", "b", "a"]) → {"c": 1, "b": 1, "a": 1}
     *
     */

    public static Map<String,Integer>wordCount(String[] array){
        Map<String,Integer>hm=new HashMap<>();
       for(String str:array){
           if(hm.containsKey(str)==true){
                int temp=hm.get(str);
               hm.put(str,new Integer(temp+1));
            }
            else{
                hm.put(str,new Integer(1));
            }
        }
        return hm;
    }


    @Test
    public static void main(String[] args) {
        String[] array1= {"ba","ba","black","sheep"};   // test should return {"ba" : 2, "black": 1, "sheep": 1 }
        String[] array2= {"a", "b", "a", "c", "b"};  // test should return {"a": 2, "b": 2, "c": 1}
        String[] array3= {"c", "b", "a"};  // test should return {"c": 1, "b": 1, "a": 1}
        Map<String,Integer>map1=wordCount(array1);
        Map<String,Integer>map2=wordCount(array2);
        Map<String,Integer>map3=wordCount(array3);
        System.out.println(wordCount(array1));
        System.out.println(wordCount(array2));
        System.out.println(wordCount(array3));

    }
}
