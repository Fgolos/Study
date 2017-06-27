package com.home.demo;

import com.home.newProject.User;
import com.home.newProject.Users;
import javafx.collections.ObservableList;

/**
 * Created by FDR on 27.06.2017.
 */
public class Counter {
    Users users;


    public Integer generateId() {
        int newId = 0;
        for (int i = 0; i < users.users.size(); i++) {
            Integer id = users.getUsers().get(i).getId();
            if (id > newId) {
                newId = users.getUsers().get(i).getId() + 1;
            }

        }
        return newId;
    }
}
