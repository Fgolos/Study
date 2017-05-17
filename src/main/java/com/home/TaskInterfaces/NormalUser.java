package com.home.TaskInterfaces;

/**
 * Created by FDR on 26.04.2017.
 */
public class NormalUser implements InterfaceUser {
    String name;
    String surname;
    public NormalUser(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String name() {
        return name;
    }

    public String surname() {
        return surname;
    }
}
