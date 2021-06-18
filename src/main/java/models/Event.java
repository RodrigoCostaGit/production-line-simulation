package models;

public class Event implements Comparable<Event> {
    private double time;
    private final EventHandler handler;


    public Event(double time, EventHandler handler){
        this.time = time;
        this.handler = handler;


    }

    @Override
    public int compareTo(Event o) {
        return Double.compare(this.time,o.time);
    }

    public double getTime(){
        return this.time;
    }

    public EventHandler getHandler(){
        return this.handler;
    }

}
