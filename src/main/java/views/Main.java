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

    public static void loadDefault(){
//        System.out.println("loading default");
        //adds the default zones with corresponding lines
        List<Integer> list = Arrays.asList(3,2,4,3,1);
        for(int num : list){
            Zone zone = new Zone(num,sim);
            sim.addZone(zone);
        }

        List order1 = Arrays.asList(4,1,3);
        List avgTime1 = Arrays.asList(1.10,0.8,0.75);
        ZonePair zonepair1 = new ZonePair(order1,avgTime1);

        List order2 = Arrays.asList(3,1,2,5);
        List avgTime2 = Arrays.asList(0.5,0.6,0.85,0.5);
        ZonePair zonepair2 = new ZonePair(order2,avgTime2);

        List order3 = Arrays.asList(2,5,1,4,3);
        List avgTime3 = Arrays.asList(1.20,0.25,0.70,0.90,1.00);
        ZonePair zonepair3 = new ZonePair(order3,avgTime3);

        //adds the default cars
        Car car = new Car(3,7,zonepair1,"1",sim);


        Car car2 = new Car(4,6,zonepair2,"2",sim);


        Car car3 = new Car(2,5,zonepair3,"3",sim);

        sim.addCar(3,7,zonepair1,"1");
        sim.addCar(4,6,zonepair2,"2");
        sim.addCar(2,5,zonepair3,"3");
        sim.queueCarEvents(8760);


    }

    public static FactorySimulator getSim(){
        return sim;
    }

}
