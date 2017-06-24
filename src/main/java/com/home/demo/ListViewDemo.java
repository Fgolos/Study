package com.home.demo;

import com.home.newProject.Serial;
import com.home.newProject.User;
import com.home.newProject.Users;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class ListViewDemo extends Application {
    Serial serial;


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws IOException, ClassNotFoundException {
        Serial serial = new Serial("test.out");
        TableView<User> userTableView = new TableView<>();


        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(450);
        stage.setHeight(500);

        TableColumn<User, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setMinWidth(100);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<User, String> nameColumn = new TableColumn<>("NAME");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<User, String> surnameColumn = new TableColumn<>("SURNAME");
        surnameColumn.setMinWidth(200);
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));

        userTableView.setItems(getUser());
        userTableView.getColumns().addAll(idColumn, nameColumn, surnameColumn);


        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(userTableView);


        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    public ObservableList<User> getUser() throws IOException, ClassNotFoundException {

        ObservableList<User> userObservableList = FXCollections.observableArrayList();
        for (int i = 0; i < serial.retriveFromFile().users.size(); i++) {
            userObservableList.add(serial.retriveFromFile().users.get(i));
        }
        return userObservableList;


    }

}
