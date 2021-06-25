package controller;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import views.Main;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GuiController implements Initializable {
    public Button button;
    @FXML
    private TextArea output;
    private Service<Void> backgroundThread;

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

    public void StartButton(){
        System.out.println("starting simulation");
        output.setText("");
        Main.getSim().run(8760);
        //old ways
//        Main.getSim().getStatistics().getStats("1");
//        output.setText(Main.getSim().getStatistics().getStats("1")+System.lineSeparator()+Main.getSim().getStatistics().getStats("2"));
        //new way
        List<String> lista = Main.getSim().getStatistics().getStats();
        for(String text:lista){
            System.out.println(text);
            output.setText(output.getText()+text+System.lineSeparator());
        }

    }

    public void ResetButton(){
        Main.getSim().getStatistics().reset();
        Main.loadDefault();
        System.out.println("reseting");
        output.setText("");

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("loading default settings");
        Main.loadDefault();
    }


}
