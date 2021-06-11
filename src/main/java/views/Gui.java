package views;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;

public class Gui extends Application {

    Button button,start,reset,settings,leftArrow,rightArrow;
    Scene scene1;




    public static void main(String[] args) {
    launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("projeto PP");
        settings = new Button("settings");
        settings.setOnAction(e->Settings.display());

        StackPane layout = new StackPane();
        layout.getChildren().addAll(settings);
        Scene scene1 = new Scene(layout,500,500);
        stage.setScene(scene1);
        stage.show();


    }

}
