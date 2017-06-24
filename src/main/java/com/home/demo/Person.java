package com.home.demo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by z003a0ns on 23.06.2017.
 */
public class Person {

    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty surname;

    public Person(Integer id, String name, String surname) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
    }


    public SimpleIntegerProperty firstNameProperty() {
        return id;
    }


    public SimpleStringProperty lastNameProperty() {
        return name;
    }


    public SimpleStringProperty emailProperty() {
        return surname;
    }
}
