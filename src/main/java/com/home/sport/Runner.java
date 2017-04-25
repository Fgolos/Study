package com.home.sport;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Created by FDR on 21.04.2017.
 */
public class Runner {
    public static void main(String[] args) throws IOException {
        File file = new File("C:/Users/Fgolo/Desktop/sport.txt");
        ArrayList<Sportsmen> sportsmens = parseSportsmens(file);
        System.out.println(sportsmens);
        WinnerFinder winnerFinder = new WinnerFinder(sportsmens);
        winnerFinder.showWinner();

    }

    public static ArrayList<Sportsmen> parseSportsmens(File file) throws IOException {
        ArrayList<Sportsmen> parseSportsmens = new ArrayList<>();
        List<String> strings = Files.readLines(file, UTF_8);
        for (int i = 0; i < strings.size(); i++) {
            parseSportsmens.add(Sportsmen.parseSportsmenFromString(strings.get(i)));
        }
        return parseSportsmens;
    }
}
