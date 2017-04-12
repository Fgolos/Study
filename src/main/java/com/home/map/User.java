package com.home.map;

/**
 * Created by FDR on 11.04.2017.
 */
public class User {
    int id;
    String name;
    String surname;
    public User(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }



    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", surname='" + surname + '\'' + '}';
    }
}


