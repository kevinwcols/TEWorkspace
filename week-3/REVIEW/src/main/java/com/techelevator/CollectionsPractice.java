package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionsPractice {
    public static void main(String[] args) {
        int valuesInArray = 10;
        int[] numbers = new int[valuesInArray];

        // provide a number from 0 to valuesInArray
        // multiply that number by itself, and store in array
        for(int i = 0; i < valuesInArray; i++) {
            numbers[i] = i * i;
        }

        for(int item : numbers) {
            if(item % 2 == 0) {
                System.out.println(item);
            }
        }

        // compare to list
        List<Integer> moreNumbers = new ArrayList<Integer>();

        for(int i = 0; i < valuesInArray; i++) {
            moreNumbers.add(i * i);
        }


        for(Integer item : moreNumbers) {
            if(item % 2 == 1) {
                System.out.println(item);
            }
        }

        for(int i = 0; i < valuesInArray; i++) {
            moreNumbers.add(i + i);
        }
        System.out.println(moreNumbers);

        for(int i = 0; i < numbers.length;i++) {
            System.out.println("From the array " + numbers[i]);
        }
        for(int i = 0; i < moreNumbers.size();i++){
            System.out.println("From the list " + moreNumbers.get(i));
        }

        // Constructor example
        List<Integer> built = new ArrayList<>(moreNumbers);

        // Maps example
        Map<String, String> footballTeams = new HashMap<String,String>();
        footballTeams.put("Pittsburgh","Steelers");
        footballTeams.put("Seattle","Seahawks");
        footballTeams.put("Dallas","Cowboys");
        footballTeams.put("Carolina","Panthers");

        System.out.println(footballTeams.get("Seattle"));

        // What cities have football teams
        // loop through the keys
        for(String city : footballTeams.keySet()) {
            System.out.println(city);
            System.out.println(city + " has the " + footballTeams.get(city));
        }

        // What are the names of the team
        // loop through the values
        for(String names : footballTeams.values()) {
            System.out.println(names);
        }

        // What if I need both?
        for(Map.Entry<String,String> kvp : footballTeams.entrySet()) {
            System.out.println(kvp.getKey() + " is the home of the " + kvp.getValue());
        }

        // fancy maps
        Map<String,List<String>> sportsTeams = new HashMap<>();
        List<String> teams = new ArrayList<>();
        teams.add("Steelers");
        teams.add("Pirates");
        teams.add("Penguins");
        teams.add("Knights");
        teams.add("Pathers");
        sportsTeams.put("Pittsburgh",teams);

        teams = new ArrayList<>();
        teams.add("Seahawks");
        teams.add("Mariners");
        teams.add("Kraken");
        sportsTeams.put("Seattle",teams);
        System.out.println("All Added");

        for(String key : sportsTeams.keySet()) {
            System.out.println(key);
            List<String> retrievedList = sportsTeams.get(key);
            for(String item : retrievedList) {
                System.out.println(item);
            }
            System.out.println("---------");
        }
    }
}
