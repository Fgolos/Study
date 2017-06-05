package com.home.newProject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.IOException;

/**
 * Created by FDR on 05.06.2017.
 */
public class ShowUserEventHanler implements EventHandler<ActionEvent> {
    Serial serial;

    public ShowUserEventHanler(Serial serial) {
        this.serial = serial;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            User x = serial.retriveFromFile();
            System.out.println(x);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
