package com.home.demo;

import com.home.newProject.Serial;
import com.home.newProject.User;
import com.home.newProject.Users;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


public class ListViewDemo extends Application {
    Users users;
    Serial serial;
    TableView<User> userTableView;
    ObservableList<User> userObservableList;

    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage stage) throws IOException, ClassNotFoundException {


        userTableView = new TableView<>();


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

        Button button = new Button("Add User");
        Button buttonDeleteUser = new Button("Delete user");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                createSceneAddUser();
            }
        });

        buttonDeleteUser.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int selectedItems = userTableView.getSelectionModel().getFocusedIndex();
                userObservableList.remove(selectedItems);

            }
        });


        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(userTableView, button, buttonDeleteUser);


        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    public ObservableList<User> getUser() throws IOException, ClassNotFoundException {
        this.serial = new Serial("test.out");
        this.users = serial.retriveFromFile();
        this.userObservableList = FXCollections.observableArrayList();
        for (int i = 0; i < serial.retriveFromFile().users.size(); i++) {
            userObservableList.add(serial.retriveFromFile().users.get(i));
        }
        return userObservableList;
    }

    public void createSceneAddUser() {
        Stage stageAddUser = new Stage();
        stageAddUser.setTitle("Add User");
        VBox vBox = new VBox();
        vBox.alignmentProperty();
        Scene scene = new Scene(vBox, 200, 200);
        stageAddUser.setScene(scene);
        stageAddUser.show();

        TextField textFieldID = new TextField("ID");
        TextField textFieldNAME = new TextField("Name");
        TextField textFieldSURNAME = new TextField("Surname");

        Button save = new Button("Save");
        save.setOnAction(new EventHandler<ActionEvent>() {


            @Override
            public void handle(ActionEvent event) {
                User user = new User(Integer.parseInt(textFieldID.getText()),
                        textFieldNAME.getText(), textFieldSURNAME.getText());
                users.addUser(user);
                try {
                    serial.writeUserToFile(users);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stageAddUser.close();
                userObservableList.add(user);
            }
        });

        vBox.getChildren().addAll(textFieldID, textFieldNAME, textFieldSURNAME, save);

    }

}
