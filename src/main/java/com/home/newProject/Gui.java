package com.home.newProject;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


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

        SaveUserEventHandler saveUserEventHandler = new SaveUserEventHandler(serial, textFieldName, textFieldSurname);
        uploadButton.setOnAction(saveUserEventHandler);

        ShowUserEventHanler showUserEventHanler = new ShowUserEventHanler(serial);
        downloadButton.setOnAction(showUserEventHanler);


        flowPane.getChildren().addAll(labelName, textFieldName, labelSurname, textFieldSurname, uploadButton, downloadButton);
        myStage.show();


    }
}
