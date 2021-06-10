package models;

import java.util.List;

public class car {
    private int arrivalMin;
    private int arrivalMax;
    private zone zone;
    private List zoneList;
    private String carName;

    public car(int arrivalMin, int arrivalMax,List zoneList, String carName) {
        this.arrivalMin = arrivalMin;
        this.arrivalMax = arrivalMax;
        this.zone = zone;
        this.zoneList = zoneList;
        this.carName = carName;
    }

}
