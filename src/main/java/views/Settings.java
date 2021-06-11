package views;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;


public class Settings {

    public static void display(){
        Button addCar, addZone, resetToDefault, save,exit;
        Stage stage = new Stage();
        stage.setTitle("settings");
        stage.setMinWidth(500);
        stage.setMinHeight(500);
        stage.initModality(Modality.APPLICATION_MODAL);



        addCar = new Button("add car");
        addCar.setOnAction(e->AddCar.display());

        VBox layout = new VBox();
        layout.getChildren().addAll(addCar);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.showAndWait();



    }
}
