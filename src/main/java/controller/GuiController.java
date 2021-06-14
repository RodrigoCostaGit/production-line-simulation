package controller;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GuiController implements Initializable {
    public Button button;

    public void settingsButton(){
        System.out.println("entering settings...");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("SettingsMenu.fxml"));            /*
             * if "fx:controller" is not set in fxml
             * fxmlLoader.setController(NewWindowController);
             */
            Scene scene = new Scene(root, 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Settings");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("loading default settings");
    }
}
