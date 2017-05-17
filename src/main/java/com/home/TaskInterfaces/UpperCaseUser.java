package com.home.TaskInterfaces;

/**
 * Created by FDR on 26.04.2017.
 */
public class UpperCaseUser implements InterfaceUser {
    String name;
    String surname;

    public UpperCaseUser(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String name() {
        return name.toUpperCase();
    }

    public String surname() {
        return surname.toUpperCase();
    }
}
