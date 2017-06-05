package com.home.newProject;

import com.google.common.io.Files;
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

import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Created by FDR on 27.05.2017.
 */
public class Gui extends Application {
    Serial serial = new Serial("test.out");


    public static void main(String[] args) {
        launch(args);


    }

    public void start(Stage myStage) {
        myStage.setTitle("Project");
        FlowPane flowPane = new FlowPane(10, 10);
        flowPane.setAlignment(Pos.CENTER);
        Scene scene = new Scene(flowPane, 200, 200);
        myStage.setScene(scene);

        Label labelName = new Label("Введите имя");
        TextField textFieldName = new TextField("");
        Label labelSurname = new Label("Введите Фамилию");
        TextField textFieldSurname = new TextField("");
        Button uploadButton = new Button("Save");
        Button downloadButton = new Button("Show");

        uploadButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                User user = new User(textFieldName.getText(), textFieldSurname.getText());

                try {
                    serial.writeUserToFile(user);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                downloadButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {
                            serial.User x = serial.retriveFromFile();
                            System.out.println(x);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        flowPane.getChildren().addAll(labelName, textFieldName, labelSurname, textFieldSurname, uploadButton, downloadButton);
        myStage.show();


    }
}
