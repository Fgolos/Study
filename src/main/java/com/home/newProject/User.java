package com.home.newProject;

import java.io.Serializable;

/**
 * Created by FDR on 27.05.2017.
 */
public class User implements Serializable {
    String name;
    String surname;
    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", surname='" + surname + '\'' + '}';
    }

}
