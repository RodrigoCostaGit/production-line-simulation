package views;
import controller.GuiController;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;


public class Main extends Application {


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
}
