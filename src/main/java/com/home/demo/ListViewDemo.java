package com.home.demo;

import com.home.newProject.User;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.ArrayList;

/**
 * Created by FDR on 22.06.2017.
 */
public class ListViewDemo extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage myStage) {
        ArrayList<User> users = new ArrayList<>();

        User user = new User(1, "name1", "surname1");
        User user2 = new User(2, "name2", "surname2");

        users.add(user);
        users.add(user2);

        myStage.setTitle("ListView Demo");
        FlowPane flowPane = new FlowPane(10, 10);
        flowPane.setAlignment(Pos.CENTER);
        Scene scene = new Scene(flowPane, 200, 120);
        myStage.setScene(scene);

        javafx.scene.control.TableView tableView = new javafx.scene.control.TableView();

        TableColumn tableColumnID = new TableColumn("ID");
        TableColumn tableColumnNAME = new TableColumn("Name");
        TableColumn tableColumnSURNAME = new TableColumn("Surname");
        tableColumnID.setCellValueFactory(new PropertyValueFactory<User, String>("ID"));


        tableView.getColumns().addAll(tableColumnID, tableColumnNAME, tableColumnSURNAME);
        tableView.getItems().addAll();


//        ObservableList<User> computerTypes = FXCollections.observableArrayList(user, user2);
//        ListView<User> lvComputers = new ListView<>(computerTypes);
//        lvComputers.setPrefSize(200, 120);
//        MultipleSelectionModel<User> selectionModel = lvComputers.getSelectionModel();

        flowPane.getChildren().addAll(tableView);
        myStage.show();
    }
}
