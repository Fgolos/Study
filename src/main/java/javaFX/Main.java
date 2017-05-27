package javaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.event.EventHandler;
import com.home.project.Serializer;
import serial.User;


import java.io.IOException;


/**
 * Created by FDR on 17.05.2017.
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);


    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        User egorka = new User("Egorka", 25);

        Serializer serializer = new Serializer("file.out");
        serializer.writeUserToFile(egorka);

        Label label = new Label("Ввод текста");
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(label, 0, 1);
        TextField textField = new TextField();
        gridPane.add(textField, 1, 1);

        Text text = new Text(10, 20, "Программа приветствия Егорки");
        Button button = new Button("Поприветствовать Егорку");
        text.setFont(new Font(20));

        textField.setText(textField.getText());

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(textField);
        borderPane.setCenter(button);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    System.out.println(serializer.retriveFromFile());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });


        Scene scene = new Scene(borderPane, 400, 400);
        primaryStage.setTitle("javaFX Title");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
