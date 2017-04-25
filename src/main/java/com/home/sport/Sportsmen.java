package com.home.sport;

import java.util.ArrayList;

/**
 * Created by FDR on 21.04.2017.
 */
public class Sportsmen {
    String name;
    ArrayList<Integer> attempt;

    public Sportsmen(String name, ArrayList<Integer> attempt) {
        this.name = name;
        this.attempt = attempt;
    }

    public static Sportsmen parseSportsmenFromString(String string) {
        String[] split = string.split(" ");
        ArrayList<Integer> resultsOfSportsmen = new ArrayList<>();
        for (int i = 1; i < split.length; i++) {
            resultsOfSportsmen.add(Integer.valueOf(split[i]));
        }
        Sportsmen sportsmen = new Sportsmen(split[0], resultsOfSportsmen);
        return sportsmen;


    }

    @Override
    public String toString() {
        return "Sportsmen{" + "name='" + name + '\'' + ", attempt=" + attempt + '}';
    }

    public Integer bestAttempt() {
        Integer bestAttempt = 0;
        for (int i = 0; i < attempt.size(); i++) {
            if (attempt.get(i) > bestAttempt) {
                bestAttempt = attempt.get(i);
            }
        }
        return bestAttempt;
    }
}
