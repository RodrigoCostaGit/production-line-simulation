package models;

import controller.FactorySimulator;

public class Car extends EventHandler {
    private int arrivalMin;
    private int arrivalMax;
    private Zone zone;
    private ZonePair zoneList;
    private String carName;

    public Car(int arrivalMin, int arrivalMax, ZonePair zoneList, String carName, FactorySimulator sim) {
        this.arrivalMin = arrivalMin;
        this.arrivalMax = arrivalMax;
        this.zone = zone;
        this.zoneList = zoneList;
        this.carName = carName;
    }

    @Override
    public void handleEvent(double time) {
        zone


    }
    @Override
    public int getArrivalMin() {
        return arrivalMin;
    }
    @Override
    public int getArrivalMax() {
        return arrivalMax;
    }

    public Zone getZone() {
        return zone;
    }

    public ZonePair getZoneList() {
        return zoneList;
    }

    public String getCarName() {
        return carName;
    }
}
