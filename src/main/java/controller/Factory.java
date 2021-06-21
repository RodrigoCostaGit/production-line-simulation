package controller;

import models.Car;
import models.Event;
import models.EventHandler;
import models.Zone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Factory {

    public void setEvent(double time, EventHandler handler);

    public void handleEvent(Event e);

    public void addCar(Car car);

    public void queueCarEvents(int time);

    public void addZone(Zone zone);

    public void run(int maxTime);

}
