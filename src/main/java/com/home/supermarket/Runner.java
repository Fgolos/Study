package com.home.supermarket;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by FDR on 20.03.2017.
 */
public class Runner {
    public static void main(String[] args) {
        String omg = "авав";
        System.out.println(calculateStatistic(omg));

    }

    public static HashMap<Character, Integer> calculateStatistic(String omg) {
        Map<Character, Integer> result = new HashMap<>();
        char[] chars = omg.toCharArray();

        for (int i = 0; i < omg.length(); i++) {
            char a = chars[i];
            if (result.containsKey(a)) {
                Integer value = result.get(a);
                value = value + 1;
                result.put(a, value);
            } else result.put(a, 1);
        }
        return (HashMap<Character, Integer>) result;

    }
}



