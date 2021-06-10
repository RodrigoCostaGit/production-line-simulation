package controller;

import models.Car;
import models.Zone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Factory {
    private List<Zone> zoneList;
    private List<Car> carList;

    public Factory() {

    }

    public void addZone(Zone zone) {
        zoneList.add(zone);
    }

    //checks to see if a zone exists
    public boolean zoneChecker(int num){
        for(Zone zone : zoneList){
            if(zone.getZoneId()==num){
                return true;
            }
            else{
                return false;
        }
        }
        return false;
    }

    public void addCar(Car car) {

        this.carList.add(car);
    }



}
