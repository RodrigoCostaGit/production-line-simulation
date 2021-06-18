package views;

import controller.Factory;
import controller.FactorySimulator;
import models.Car;
import models.Zone;
import models.ZonePair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class app {
    public static void main(String[] args){
        Factory factory = new Factory();
        FactorySimulator sim = new FactorySimulator();
        Random random = new Random();

        //adds the default zones with corresponding lines
        List<Integer> list = Arrays.asList(3,2,4,3,1);
        for(int num : list){
            Zone zone = new Zone(num);
            sim.addZone(zone);
        }

        List order1 = Arrays.asList(4,1,3);
        List avgTime1 = Arrays.asList(1,10,0.8,0.75);
        ZonePair zonepair1 = new ZonePair(order1,avgTime1);

        List order2 = Arrays.asList(3,1,2,5);
        List avgTime2 = Arrays.asList(0.5,0.6,0.85,0.5);
        ZonePair zonepair2 = new ZonePair(order2,avgTime2);

        List order3 = Arrays.asList(2,5,1,4,3);
        List avgTime3 = Arrays.asList(1.20,0.25,0.70,0.90,1);
        ZonePair zonepair3 = new ZonePair(order3,avgTime3);

        //adds the default cars
        Car car = new Car(3,7,zonepair1,"1");


        Car car2 = new Car(4,6,zonepair2,"2");


        Car car3 = new Car(2,5,zonepair3,"3");


        sim.addCar(car);
        sim.addCar(car2);
        sim.addCar(car3);
        sim.queueCarEvents(8760);
        sim.testclass();


    }
}
