package com.home.telephone;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Created by FDR on 19.04.2017.
 */
public class Telephone {
    public static void main(String[] args) throws IOException {
        File file = new File("C:/Users/Fgolo/Desktop/Telephone.txt");
        String info = "124568 Fedor Goloschapov";
        System.out.println(parseAllUsers(file));
        System.out.println(sortedUsersInfo(parseAllUsers(file)));


    }

    public static void swap(int index1, int index2, ArrayList<UserInfo> userInfo) {
        UserInfo userInfo1 = userInfo.get(index1);
        UserInfo userInfo2 = userInfo.get(index2);
        userInfo.set(index1, userInfo2);
        userInfo.set(index2, userInfo1);


    }

    public static ArrayList<UserInfo> sortedUsersInfo(ArrayList<UserInfo> users) {
        for (int i = users.size() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (users.get(j).telephone > users.get(j + 1).telephone) {
                    swap(j, j + 1, users);
                }
            }
        }
        return users;
    }

    public static UserInfo parseUserInfo(String info) {
        String[] split1 = info.split(" ");
        UserInfo userInfo = new UserInfo((Integer.parseInt(split1[0])), split1[1], split1[2]);
        return userInfo;
    }

    public static ArrayList<UserInfo> parseAllUsers(File file) throws IOException {
        List<String> strings = Files.readLines(file, UTF_8);
        ArrayList<UserInfo> res = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            res.add(parseUserInfo(strings.get(i)));
        }
        return res;
    }
}


