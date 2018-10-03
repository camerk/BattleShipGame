package com.BSG;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application{

    Button b1;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("*Stage Title*");

        b1 = new Button();
        b1.setText("Click Me");

        StackPane layout = new StackPane();
        layout.getChildren().add(b1);

        Scene scene1 = new Scene(layout, 300, 250);
        primaryStage.setScene(scene1);
        primaryStage.show();


    }
}
