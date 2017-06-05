package com.home.newProject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Created by FDR on 05.06.2017.
 */
public class SaveUserEventHandler implements EventHandler<ActionEvent> {
    Serial serial;
    TextField textFieldName;
    TextField textFieldSurname;

    public SaveUserEventHandler(Serial serial, TextField textFieldName, TextField textFieldSurname) {
        this.serial = serial;
        this.textFieldName = textFieldName;
        this.textFieldSurname = textFieldSurname;
    }

    @Override
    public void handle(ActionEvent event) {
        System.out.println("user saved");
        User user = new User(textFieldName.getText(), textFieldSurname.getText());
        try {
            serial.writeUserToFile(user);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
