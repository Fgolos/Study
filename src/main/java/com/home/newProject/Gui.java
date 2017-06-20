package com.home.newProject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static javafx.geometry.Pos.BASELINE_RIGHT;
import static javafx.geometry.Pos.CENTER;


/**
 * Created by FDR on 27.05.2017.
 */
public class Gui extends Application {
    Serial serial = new Serial("test.out");
    ArrayList<CheckBoxAndUsersID> checkBoxAndUsersIDArrayList = new ArrayList<>();


    public static void main(String[] args) {
        launch(args);


    }

    public void start(Stage myStage) throws IOException, ClassNotFoundException {
        Gui gui = new Gui();
        gui.createMainScene(myStage);

    }

    public void createMainScene(Stage myStage) throws IOException, ClassNotFoundException {
        myStage.setTitle("Project");
        GridPane gridPane = new GridPane();

        gridPane.setGridLinesVisible(true);
        Scene scene = new Scene(gridPane, 500, 200);
        myStage.setScene(scene);
        myStage.show();


        Label id = new Label("ID");
        id.setAlignment(Pos.BASELINE_CENTER);
        gridPane.add(id, 0, 0);
        gridPane.add(new Label("Name"), 1, 0);
        gridPane.add(new Label("Surname"), 2, 0);
        //  CheckBox checkBox = new CheckBox();
        Button buttonAddUser = new Button("Add User");
        Button buttonDeleteUser = new Button("Delete User");


        ColumnConstraints columnConstraintsID = new ColumnConstraints();
        columnConstraintsID.setPrefWidth(50);
        ColumnConstraints columnConstraintsName = new ColumnConstraints();
        columnConstraintsName.setPrefWidth(250);
        ColumnConstraints columnConstraintsSurname = new ColumnConstraints();
        columnConstraintsSurname.setPrefWidth(250);
        ColumnConstraints columnConstraintsCheckBox = new ColumnConstraints();
        columnConstraintsCheckBox.setPrefWidth(17);
        gridPane.getColumnConstraints().addAll(columnConstraintsID, columnConstraintsName, columnConstraintsSurname, columnConstraintsCheckBox);

        Users users = serial.retriveFromFile();
        gridPane.add(buttonAddUser, 2, users.users.size() + 1);
        gridPane.add(buttonDeleteUser, 1, users.users.size() + 1);
        buttonAddUser.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Gui gui = new Gui();
                try {
                    gui.createAddUserScene(myStage);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });
        buttonDeleteUser.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(users.users.size());
                for (int i = 0; i < checkBoxAndUsersIDArrayList.size(); i++) {
                    if (checkBoxAndUsersIDArrayList.get(i).checkBox.isSelected()) {
                        users.removeUserByID(checkBoxAndUsersIDArrayList.get(i).id);
                    }
                }
                System.out.println(users.users.size());
                try {
                    serial.writeUserToFile(users);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });

        for (int i = 0; i < users.users.size(); i++) {
            String id1 = String.valueOf(users.users.get(i).id);
            gridPane.add(new Label(id1), 0, i + 1);
            String name = users.users.get(i).name;
            gridPane.add(new Label(name), 1, i + 1);
            String surname = users.users.get(i).surname;
            gridPane.add(new Label(surname), 2, i + 1);
            CheckBox checkBox = new CheckBox();
            gridPane.add(checkBox, 3, i + 1);
            CheckBoxAndUsersID checkBoxAndUsersID = new CheckBoxAndUsersID(checkBox, Integer.parseInt(id1));
            checkBoxAndUsersIDArrayList.add(checkBoxAndUsersID);
        }

    }

    public void createAddUserScene(Stage myStage) throws IOException, ClassNotFoundException {
        Users users = serial.retriveFromFile();
        Gui gui = new Gui();

        Stage stage = new Stage();
        stage.setTitle("Add User");
        GridPane gridPane1AddUser = new GridPane();
        Scene scene1 = new Scene(gridPane1AddUser, 200, 200);
        stage.setScene(scene1);
        stage.show();

        TextField textFieldID = new TextField("");
        TextField textFieldNAME = new TextField("");
        TextField textFieldSURNAME = new TextField("");
        Button saveButton = new Button("Save");
        gridPane1AddUser.setAlignment(CENTER);
        gridPane1AddUser.add(new Label("ID "), 0, 0);
        gridPane1AddUser.add(new Label("Name "), 0, 1);
        gridPane1AddUser.add(new Label("Surname "), 0, 2);
        gridPane1AddUser.add(textFieldID, 1, 0);
        gridPane1AddUser.add(textFieldNAME, 1, 1);
        gridPane1AddUser.add(textFieldSURNAME, 1, 2);
        gridPane1AddUser.add(saveButton, 1, 3);

        saveButton.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                User user = new User(Integer.parseInt(textFieldID.getText()), textFieldNAME.getText(), textFieldSURNAME.getText());
                Users users1 = users;
                users1.addUser(user);
                try {
                    serial.writeUserToFile(users1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(users.users.size());
                myStage.close();
                stage.close();
                try {
                    gui.createMainScene(myStage);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
