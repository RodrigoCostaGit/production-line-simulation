package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import models.Car;
import models.Event;
import models.Zone;
import models.ZonePair;
import views.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CarAddGui implements Initializable {
    List order = new ArrayList();
    List avgTime = new ArrayList();
    ObservableList<Object> ZonesAddedList = FXCollections.observableArrayList();


    @FXML
    private Spinner<Integer> spinnerRateMin;

    @FXML
    private Spinner<Integer> spinnerRateMax;

    @FXML
    private Spinner<Double> spinnerRateZone;

    @FXML
    private ComboBox comboboxZones;

    @FXML
    private ListView<Object> zoneListView;

    @FXML
    private TextField nameCar;

    @FXML
    private Button exit;


    int currentSpinnerRateMin;
    int currentSpinnerRateMax;
    double currentSpinnerRateZone;
    String name;


    public void addZoneButton(){
        currentSpinnerRateZone = spinnerRateZone.getValue();
        order.add(comboboxZones.getValue());
        avgTime.add(currentSpinnerRateZone);
        System.out.println(order);
        System.out.println(avgTime);
        ZonesAddedList.add("zona:"+(int)comboboxZones.getValue()+"    rate:"+(double)spinnerRateZone.getValue());
        zoneListView.setItems(ZonesAddedList);
    }

//    public void addCarName(){
//        name=nameCar.getText();
//    }

    public void finishAddCar(){
        name=nameCar.getText();
        currentSpinnerRateMin =spinnerRateMin.getValue();
        currentSpinnerRateMax = spinnerRateMax.getValue();
        System.out.println(currentSpinnerRateMin);
        System.out.println(currentSpinnerRateMax);
        ZonePair zonepair = new ZonePair(order,avgTime);
        Main.getSim().addCar(currentSpinnerRateMin,currentSpinnerRateMax,zonepair,name);

    }

    public void closeButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("SettingsMenu.fxml"));
            Stage window =(Stage) exit.getScene().getWindow();
        window.setScene(new Scene(root,600,400));

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("entering car add settings");
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100);
        valueFactory.setValue(1);
        spinnerRateMin.setValueFactory(valueFactory);

        SpinnerValueFactory<Integer> valueFactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100);
        valueFactory1.setValue(1);
        spinnerRateMax.setValueFactory(valueFactory1);

        SpinnerValueFactory<Double> valueFactory2 = new SpinnerValueFactory.DoubleSpinnerValueFactory(0.1,100.0);
        valueFactory2.setValue(1.0);
        spinnerRateZone.setValueFactory(valueFactory2);


        ObservableList<Integer> options = FXCollections.observableArrayList();

        for(Zone event:Main.getSim().getZoneList()){
            options.add(event.getZoneId());
            System.out.println(event.getZoneId());
        }

        comboboxZones.getItems().addAll(options);



    }
}
