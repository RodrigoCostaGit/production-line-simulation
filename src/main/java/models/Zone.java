package models;

import java.util.List;
import java.util.concurrent.ThreadFactory;

public class Zone implements ThreadFactory {
    private int numLines;
    private String lineName;
    private static int counter=0;
    private int zoneId;
    private int lineCounter=0;

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
    public int getZoneId(){
        return this.zoneId;
    }
}
