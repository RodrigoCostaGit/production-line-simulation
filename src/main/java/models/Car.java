package models;

import java.util.List;

public class Car {
    private int arrivalMin;
    private int arrivalMax;
    private Zone zone;
    private ZonePair zoneList;
    private String carName;

    public Car(int arrivalMin, int arrivalMax,ZonePair zoneList, String carName) {
        this.arrivalMin = arrivalMin;
        this.arrivalMax = arrivalMax;
        this.zone = zone;
        this.zoneList = zoneList;
        this.carName = carName;
    }

}
