package com.home.demo;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by z003a0ns on 23.06.2017.
 */
public class Person  {

  private final SimpleStringProperty firstName;
  private final SimpleStringProperty lastName;
  private final SimpleStringProperty email;

  public Person(String fName, String lName, String email) {
    this.firstName = new SimpleStringProperty(fName);
    this.lastName = new SimpleStringProperty(lName);
    this.email = new SimpleStringProperty(email);
  }



  public SimpleStringProperty firstNameProperty() {
    return firstName;
  }



  public SimpleStringProperty lastNameProperty() {
    return lastName;
  }



  public SimpleStringProperty emailProperty() {
    return email;
  }
}
