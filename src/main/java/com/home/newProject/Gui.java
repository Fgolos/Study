package com.home.newProject;

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

/**
 * Created by FDR on 27.05.2017.
 */
public class Gui extends Application {
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
        Button enterButton = new Button("ENTER");

        enterButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                User user = new User(textFieldName.getText(), textFieldSurname.getText());
                System.out.println(user);
            }
        });

        flowPane.getChildren().addAll(labelName, textFieldName, labelSurname, textFieldSurname, enterButton);
        myStage.show();


    }
}
