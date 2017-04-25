package com.home.map;

import com.google.common.io.Files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Created by FDR on 07.04.2017.
 */
public class Test {

    public static void main(String[] args) throws IOException {
        File file = new File("C:/Users/Fgolo/Desktop/test.txt");
        File file2 = new File("C:/Users/Fgolo/Desktop/test2.txt");
        User user = new User(4, "Egor", "Goloshcapov");
        ArrayList<User> users = parseUserseWithUpperCase(file);
        for (int i = 0; i < users.size(); i++) {
            User user1 = users.get(i);
            String s = user1.toStringWithSeparator();
            addLine(file2, s);
        }


    }

    public static void addLine(File file, String text) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(file, true), true);
        printWriter.println(text);
        printWriter.close();


    }

    public static ArrayList<User> parseUserse(File file) throws IOException {
        List<String> linesFromFile = Files.readLines(file, UTF_8);
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < linesFromFile.size(); i++) {
            User user = addUserInfo(linesFromFile.get(i));
            users.add(i, user);
        }
        return users;
    }

    public static ArrayList<User> parseUserseWithUpperCase(File file) throws IOException {
        List<String> linesFromFile = Files.readLines(file, UTF_8);
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < linesFromFile.size(); i++) {
            User user = addUserWithUpperCase(linesFromFile.get(i));
            users.add(i, user);
        }
        return users;
    }

    public static User addUserInfo(String text) {
        String[] split = text.split(";");
        Integer id = Integer.valueOf((split[0]));
        String name = split[1];
        String surname = split[2];
        User user = new User(id, name, surname);

        return user;
    }

    public static User addUserWithUpperCase(String text) {
        String[] split = text.split(";");
        Integer id = Integer.valueOf((split[0]));
        String name = split[1];
        String nameUpperCase = name.toUpperCase();
        String surname = split[2];
        String surnameUpperCase = surname.toUpperCase();
        User user = new User(id, nameUpperCase, surnameUpperCase);
        return user;
    }

}




