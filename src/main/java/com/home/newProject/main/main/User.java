package com.home.newProject.main.main;

import java.io.Serializable;

/**
 * Created by FDR on 27.05.2017.
 */
public class User implements Serializable {
    Integer id;
    String name;
    String surname;
    public User(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;

    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", surname='" + surname + '\'' + '}';
    }


}
