package com.home.map;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Created by FDR on 07.04.2017.
 */
public class Test {
    public static void main(String[] args) throws IOException {


        File file = new File("C:/Users/Fgolo/Desktop/test.txt");
        String string = Files.toString(file, UTF_8);
        String[] split = string.split("\n");
        for (int i = 0; i < split.length; i++) {
            User user = addUserInfo(split[i]);
            System.out.println(user);
        }
    }

    public static User addUserInfo(String text) {
        String[] split = text.split(";");
        Integer id = Integer.valueOf((split[0]));
        String name = split[1];
        String surname = split[2];
        User user = new User(id, name, surname);

        return user;
    }
}



