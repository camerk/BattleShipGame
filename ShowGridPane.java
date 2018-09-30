/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package showgridpane;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.shape.*;



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
          rectangle.setWidth(50);
          rectangle.setHeight(50);
          rectangle.setStyle("-fx-stroke: black; -fx-fill: lightgray;");
           
          //place nodes in the grid pane
      
          //(gridpane.add(node, columnIndex, rowIndex)
          gridpane.add(rectangle, i % 10, i / 10); 
     
          
       }
       
    
      
      

       
       //create a scene and place it in the stage
       Scene scene = new Scene(gridpane);
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

