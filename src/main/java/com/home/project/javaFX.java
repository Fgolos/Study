package com.home.project;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by FDR on 25.05.2017.
 */
public class javaFX extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage myStage) {
        myStage.setTitle("Программа");//заголовок окна
        FlowPane rootNode = new FlowPane(10, 10);//разделение между элементами
        rootNode.setAlignment(Pos.CENTER);
        Scene scene = new Scene(rootNode, 300, 200);// размеры окна
        myStage.setScene(scene);
        Label label = new Label("Проверка ЛЕЙБЛА");
        Button button = new Button("Кнопка");
        rootNode.getChildren().add(button);
        rootNode.getChildren().add(label);
        myStage.show();

    }
}
