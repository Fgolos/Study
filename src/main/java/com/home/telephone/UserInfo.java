package com.home.telephone;

/**
 * Created by FDR on 19.04.2017.
 */
public class UserInfo {
    Integer telephone;
    String name;
    String surname;
    public UserInfo(Integer telephone, String name, String surname) {
        this.telephone = telephone;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "UserInfo{" + "telephone=" + telephone + ", name='" + name + '\'' + ", surname='" + surname + '\'' +
                '}';
    }
}

