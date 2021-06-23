package models;

import controller.FactorySimulator;
import javafx.event.Event;
import javafx.event.EventHandler;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ThreadFactory;

public class Zone implements ThreadFactory, EventHandler {
    private int numLines;
    private String lineName;
    private static int counter=0;
    private int zoneId;
    private int lineCounter=0;
    private Queue<models.EventHandler> queueCarsWaiting;
    private FactorySimulator sim;


    public Zone(int numLines, FactorySimulator sim){
        this.numLines = numLines;
        this.lineName = lineName;
        Zone.counter++;
        this.zoneId=Zone.counter;
        this.sim = sim;
        queueCarsWaiting = new LinkedList<models.EventHandler>();

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

    public void queue(Car car) {
        this.queueCarsWaiting.add(car);
    }

    //todo: make this trigger a event with queue up cars
    public void removeFromLine(Double time){
        lineCounter--;
        if(queueCarsWaiting.peek()==null){
            return;
        }
        else{
            //System.out.println("banana");
            sim.setEvent(time,queueCarsWaiting.poll());
        }
    }
    public int getZoneId(){
        return this.zoneId;
    }

    @Override
    public void handle(Event event) {

    }
}
