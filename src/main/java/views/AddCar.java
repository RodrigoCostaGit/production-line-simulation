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


public class AddCar {

    public static void display(){
        Stage stage = new Stage();
        //blocks user interaction with other windows until this one is taken care off
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("add car");
        stage.setMinWidth(500);
        stage.setMinHeight(500);

        Label label1 = new Label("work in progress");
        Button button1 = new Button("closes this window");
        button1.setOnAction(e->stage.close());

        VBox layout = new VBox(20);
        layout.getChildren().addAll(label1,button1);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.showAndWait();

    }

}
