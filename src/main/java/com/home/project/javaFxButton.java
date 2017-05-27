package com.home.project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by FDR on 26.05.2017.
 */
public class JavaFxButton extends Application {
    Label response;
    Serializer serial;
    serial.User user;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage myStage) {
        myStage.setTitle("Программа кнопок и их событий");
        FlowPane flowPane = new FlowPane(10, 10);
        flowPane.setAlignment(Pos.CENTER);
        Scene scene = new Scene(flowPane, 300, 200);
        myStage.setScene(scene);
        response = new Label("нажми кнопку");

        Button btnUp = new Button("Записать в файл");
        TextField nameTextField = new TextField("Имя");
        TextField surnameTextField = new TextField("Фамилия");


        btnUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        flowPane.getChildren().addAll(nameTextField, surnameTextField, btnUp);
        myStage.show();
    }
}
