/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BSG.GameBackEndAttributes;

import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.Group;



/**
 *
 * @author carolinemansueti
 */
public class ShowGridPane extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
       GridPane gridpane = new GridPane();
       gridpane.setAlignment(Pos.CENTER);
       gridpane.setPadding(new Insets(11, 11, 11, 11));
       
       
       //we need to create an 10 x 10 grid
       for(int i = 0; i < 100; i++)
       {
          Rectangle rectangle = new Rectangle();
          rectangle.setWidth(25);
          rectangle.setHeight(25);
          rectangle.setStyle("-fx-stroke: black; -fx-fill: lightgray;");
           
          //place nodes in the grid pane
      
          //gridpane.add(node, columnIndex, rowIndex)
          gridpane.add(rectangle, i % 10, i / 10); 
          
          //create and register handler
          rectangle.setOnMouseClicked(e -> {
              
              //sample
              rectangle.setStyle("-fx-fill: green;");
              
              //if position is occupied by a ship
              //rectangle.setStyle("-fx-fill: red;");
              
              //if position is not occupied by a ship
              //rectangle.setStyle("-fx-fill: white;");
              
          });
     
          
       }
       
       //create a stackpane and pass gridpane into it so ships can be stacked onto grid
       StackPane stackpane = new StackPane(gridpane);
       
       //pass stackpane into borderpane so it is the centerpiece
       BorderPane borderpane = new BorderPane(stackpane);
       
       //create armada
       //display armada in a pane
       //pass pane to borderpane so as to display the armada on the right of the borderpane
       
       //create armada to display
       Rectangle carrier = new Rectangle();
       carrier.setWidth(125);
       carrier.setHeight(25);
       carrier.setX(10);
       carrier.setY(10);
       carrier.setStyle("-fx-stroke: black; -fx-fill: purple;");
          
       Rectangle battleship = new Rectangle();
       battleship.setWidth(100);
       battleship.setHeight(25);
       battleship.setX(10);
       battleship.setY(20);
       battleship.setStyle("-fx-stroke: black; -fx-fill: blue;");
          
       Rectangle cruiser = new Rectangle();
       cruiser.setWidth(75);
       cruiser.setHeight(25);
       cruiser.setX(10);
       cruiser.setY(30);
       cruiser.setStyle("-fx-stroke: black; -fx-fill: yellow;");
          
       Rectangle destroyer = new Rectangle();
       destroyer.setWidth(75);
       destroyer.setHeight(25);
       destroyer.setX(10);
       destroyer.setY(20);
       destroyer.setStyle("-fx-stroke: black; -fx-fill: orange;");
          
       Rectangle submarine = new Rectangle();
       submarine.setWidth(50);
       submarine.setHeight(25);
       submarine.setX(10);
       submarine.setY(20);
       submarine.setStyle("-fx-stroke: black; -fx-fill: pink;");
       
      // Group armada = new Group(carrier, battleship, cruiser, destroyer, submarine);
       
       //apply a mouse event to the ship group
       carrier.setOnMouseClicked(e -> {
           carrier.setFill(Color.RED);
       });
       
       battleship.setOnMouseDragged(e -> {
           battleship.setX(e.getX());
           battleship.setY(e.getY());
       });
       
       VBox vbox = new VBox(15);
       vbox.getChildren().addAll(carrier, battleship, cruiser, destroyer, submarine);
       
       borderpane.setTop(new Text("BATTLESHIP"));
       borderpane.setRight(vbox);
       
       //create a scene and place it in the stage
       Scene scene = new Scene(borderpane);
       primaryStage.setTitle("Show Grid Pane");
       primaryStage.setScene(scene);
       primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

   

   
}

