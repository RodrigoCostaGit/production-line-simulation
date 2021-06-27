package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.Car;
import models.Zone;
import views.Main;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GuiController implements Initializable {

    @FXML
    private Spinner<Integer> SpinnerTimeInterval = new Spinner<Integer>();

    public Button button,addCar;
    @FXML
    private TextArea output;
    @FXML
    private Button exit;
    @FXML
    private Spinner<Integer> spinnerNumLines = new Spinner<Integer>();
    @FXML
    private ComboBox deleteCarComboBox = new ComboBox();

    public void settingsButton(){
        System.out.println("entering settings...");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("SettingsMenu.fxml"));
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
        Main.getSim().queueCarEvents(Main.getRunTime());
        Main.getSim().setMaxTime(Main.getRunTime());
        Thread thread = new Thread(Main.getSim());
        thread.run();
        List<String> lista = Main.getSim().getStatistics().getStats();
        for(String text:lista){
            output.setText(output.getText()+text+System.lineSeparator());
        }
        List<String> lista2 = Main.getSim().getStatistics().getStatsZone();
        for(String text2:lista2){
            output.setText(output.getText()+text2+System.lineSeparator());
        }
        System.out.println(Main.getRunTime());
        Main.getSim().resetStats();

    }

    public void ResetButton(){
        Zone.resetCounter();
        Main.loadDefault();
        System.out.println("reseting");
        output.setText("");

    }


    public void CarButton(){
        System.out.println("entering adding car...");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("AddCar.fxml"));
            Stage window =(Stage) addCar.getScene().getWindow();
            window.setScene(new Scene(root,600,500));
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }


    public void exitButton(){
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    public void addZoneButton(){
        Zone zone = new Zone(spinnerNumLines.getValue(),Main.getSim());
        Main.getSim().addZone(zone);
    }

    public void changeTime(){
        Main.setRunTime(SpinnerTimeInterval.getValue());
    }

    public void deleteCar(){
        String carName= (String) deleteCarComboBox.getValue();
        Main.getSim().deleteCar(carName);
        deleteCarComboBox.getItems().removeIf(b->b.equals(carName));

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("loading default settings");
        SpinnerValueFactory<Integer> valueFactory4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100);
        valueFactory4.setValue(1);
        this.spinnerNumLines.setValueFactory(valueFactory4);
//
        SpinnerValueFactory.IntegerSpinnerValueFactory valueFactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(100,100000);
        valueFactory1.setValue(8760);
        this.SpinnerTimeInterval.setValueFactory(valueFactory1);

        ObservableList<String> options = FXCollections.observableArrayList();
        for(List car:Main.getSim().getCar()){
            options.add((String) car.get(3));
        }
        deleteCarComboBox.getItems().addAll(options);
    }



}
