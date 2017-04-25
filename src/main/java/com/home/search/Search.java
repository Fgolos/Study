package com.home.search;

import com.google.common.io.Files;
import com.google.common.primitives.Chars;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Created by FDR on 18.04.2017.
 */
public class Search {


    public static void main(String[] args) throws IOException {
        File file = new File("C:/Users/Fgolo/Desktop/test3.txt");
        System.out.println(deleteFirstLatterFromWords(parseWordsFromFile(file)));


    }

    public static String deleteFirstLatterFromWords(ArrayList<String> string) {
        String res = "";
        for (int i = 0; i < string.size(); i++) {
            res = res + " " + minusBukva(string.get(i));
        }
        return res;
    }

    public static String minusBukva(String string) {
        String string1 = "";

        LinkedList<Character> characters = new LinkedList<>(Chars.asList(string.toCharArray()));
        characters.remove(0);
        for (int i = 0; i < characters.size(); i++) {
            string1 = string1 + characters.get(i);
        }

        return string1;
    }

    public static String maxLength(ArrayList<String> string) {
        String maxLength = string.get(0);
        for (int i = 0; i < string.size(); i++) {
            if (maxLength.length() < string.get(i).length()) {
                maxLength = string.get(i);
            }
        }
        return maxLength;
    }

    public static String minLength(ArrayList<String> string) {
        String minLength = string.get(0);
        for (int i = 0; i < string.size(); i++) {
            if (minLength.length() > string.get(i).length()) {
                minLength = string.get(i);
            }
        }
        return minLength;

    }


    public static ArrayList<String> parseWordsFromFile(File file) throws IOException {
        List<String> strings = Files.readLines(file, UTF_8);
        ArrayList<String> arrayListWithSeparator = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            String[] split = strings.get(i).split(" ");
            for (int j = 0; j < split.length; j++) {
                arrayListWithSeparator.add(split[j]);
            }
        }
        return arrayListWithSeparator;
    }


}


