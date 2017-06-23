package com.home.demo;

import com.home.newProject.User;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;


public class ListViewDemo extends Application {

  TableView table = new TableView();
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
      Scene scene = new Scene(new Group());
      stage.setTitle("Table View Sample");
      stage.setWidth(300);
      stage.setHeight(500);

      table.setEditable(true);


        TableColumn tableColumnID = new TableColumn("ID");
        TableColumn tableColumnNAME = new TableColumn("Name");
        TableColumn tableColumnSURNAME = new TableColumn("Surname");


      table.getColumns().addAll(tableColumnID, tableColumnNAME, tableColumnSURNAME);

      final VBox vbox = new VBox();
      vbox.setSpacing(5);
      vbox.setPadding(new Insets(10, 0, 0, 10));
      vbox.getChildren().addAll(table);


      ((Group) scene.getRoot()).getChildren().addAll(vbox);
       stage.setScene(scene);
        stage.show();
    }

  private void users() {
    ArrayList<User> users = new ArrayList<>();

    User user = new User(1, "name1", "surname1");
    User user2 = new User(2, "name2", "surname2");

    users.add(user);
    users.add(user2);
  }
}
