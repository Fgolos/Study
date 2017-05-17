package com.home.TaskInterfaces;

/**
 * Created by FDR on 26.04.2017.
 */
public class Runner {
    public static void main(String[] args) {
        NormalUser normalUser = new NormalUser("vova", "putin");
        UpperCaseUser upperCaseUser = new UpperCaseUser("vova", "putin");

        print(normalUser);
        print(upperCaseUser);
    }

    public static void print(InterfaceUser user) {
        System.out.println(user.name());
        System.out.println(user.surname());

    }
}
