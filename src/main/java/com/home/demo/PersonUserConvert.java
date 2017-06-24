package com.home.demo;

import com.home.newProject.User;
import com.home.newProject.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by FDR on 23.06.2017.
 */
public class PersonUserConvert {


    public ObservableList<Person> convertUserToObservableList(Users users) {
        ObservableList<Person> res = FXCollections.observableArrayList();
        for (int i = 0; i < users.users.size(); i++) {
            User user = users.users.get(i);
            Person person = new Person(user.getId(), user.getName(), user.getSurname());
            res.add(person);
        }
        return res;
    }


}
