package com.home.demo;

/**
 * Created by FDR on 27.06.2017.
 */
public class Counter {
    Users users;

    public Counter(Users users) {
        this.users = users;
    }

    public Integer generateId() {
        int newId = 1;
        for (int i = 0; i < users.users.size(); i++) {
            Integer id = users.getUsers().get(i).getId();
            if (id >= newId) {
                newId = id+1;
            }

        }
        return newId;
    }
}
