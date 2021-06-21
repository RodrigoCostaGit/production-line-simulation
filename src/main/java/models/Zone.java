package models;

import javafx.event.Event;
import javafx.event.EventHandler;

import java.util.List;
import java.util.concurrent.ThreadFactory;

public class Zone implements ThreadFactory, EventHandler {
    private int numLines;
    private String lineName;
    private static int counter=0;
    private int zoneId;
    private int lineCounter=0;
    private List queue;


    public Zone(int numLines){
        this.numLines = numLines;
        this.lineName = lineName;
        Zone.counter++;
        this.zoneId=Zone.counter;

    }



    @Override
    public Thread newThread(Runnable line) {
        numLines++;
        return new Thread(line);

    }
    public int getnumLines(){
        return numLines;
    }

    public Boolean isAvailable(){
        if(lineCounter<this.numLines){
            return true;
        }
        return false;
    }

    public void addCar(){
        ;
    }

    public void occupy(){
        lineCounter++;
    }

    public void queue(Car car){
        this.queue.add(car);

    }

    public void removeFromLine(){
        counter--;
    }
    public int getZoneId(){
        return this.zoneId;
    }

    @Override
    public void handle(Event event) {

    }
}
