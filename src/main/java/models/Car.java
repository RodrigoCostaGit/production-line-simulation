package models;

public class Car implements EventHandler{
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

    @Override
    public void handleEvent(double time) {

    }

    public int getArrivalMin() {
        return arrivalMin;
    }

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
