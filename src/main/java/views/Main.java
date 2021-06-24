package views;
import controller.FactorySimulator;
import controller.GuiController;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import models.Car;
import models.Zone;
import models.ZonePair;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Main extends Application {
    private static FactorySimulator sim = new FactorySimulator();



    @Override
    public void start(Stage primaryStage) throws Exception {
        //this line doesnt work, cant find gui.fxml edit:needed to include fxml files to the resource directory, added in the pom file
        //https://maven.apache.org/plugins/maven-resources-plugin/examples/include-exclude.html
        Parent root = FXMLLoader.load(getClass().getResource("/Gui.fxml"));
        primaryStage.setTitle("simulator");
        primaryStage.setScene(new Scene(root,600,500));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);

    }
    public static FactorySimulator getSim(){
        return sim;
    }
}
