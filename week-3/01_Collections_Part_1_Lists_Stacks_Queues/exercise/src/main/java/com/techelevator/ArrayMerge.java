package com.techelevator;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayMerge {
    public String[] listToArray1(String[] strArray1, String[] strArray2) {
        // create another String[] array of size = arr1 + arr2
        String[] thirdArray = new String[strArray1.length + strArray2.length];

        // iterate through 1st strArray1 and assign values to thirdArray
        for(int index = 0; index < strArray1.length; index++) {
            thirdArray[index] = strArray1[index];
        }

        // iterate through 2nd strArray2 and assign values to thirdArray
        for(int index = strArray1.length, i=0;
            index < strArray1.length + strArray2.length;
            index++, i++) {

            thirdArray[index] = strArray2[i];
        }

        // sorting MERGED String[] array in ascending-order
        Arrays.sort(thirdArray);

        return thirdArray;
    }

    public List<String> listToArray2(List<String> listOne, List<String> listTwo) {
        // combine Array Lists
        List<String> combinedList = Stream.of(listOne, listTwo)
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
        // sort combined Array List
        Collections.sort(combinedList);
        return combinedList;
    }
}
