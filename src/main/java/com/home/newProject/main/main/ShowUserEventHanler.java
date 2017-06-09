//package com.home.newProject;
//
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.control.TextField;
//
//import java.io.IOException;
//
///**
// * Created by FDR on 05.06.2017.
// */
//public class ShowUserEventHanler implements EventHandler<ActionEvent> {
//    Serial serial;
//    TextField textFieldName;
//    TextField textFieldSurname;
//
//
//    public ShowUserEventHanler(Serial serial, TextField textFieldName, TextField textFieldSurname) {
//        this.serial = serial;
//        this.textFieldName = textFieldName;
//        this.textFieldSurname = textFieldSurname;
//    }
//
//    @Override
//    public void handle(ActionEvent event) {
//        try {
//            User user = serial.retriveFromFile();
//            System.out.println(user);
//            String name = user.name;
//            String surname = user.surname;
//            textFieldName.setText(name);
//            textFieldSurname.setText(surname);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//}
