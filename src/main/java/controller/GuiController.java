package controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;


public class GuiController implements Initializable {
    public Button button;

    public void settingsButton(){
        System.out.println("entering settings...");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("loading default settings");
    }
}
