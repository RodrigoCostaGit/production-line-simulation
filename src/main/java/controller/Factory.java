package controller;

import models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Factory {

    public void setEvent(double time, EventHandler handler);

    public void handleEvent(Event e);


    public void queueCarEvents(int time);

    public void addCar(int arrivalMin, int arrivalMax, ZonePair zoneList, String carName);

    public void addZone(Zone zone);

    public void run(int maxTime);

}
