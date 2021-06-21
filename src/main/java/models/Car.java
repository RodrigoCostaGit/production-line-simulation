package models;

import controller.FactorySimulator;
import org.apache.commons.math3.distribution.GammaDistribution;

public class Car extends EventHandler {
    private int arrivalMin;
    private int arrivalMax;
    private Zone zone;
    private ZonePair zoneList;
    private int counter=1;
    private String carName;
    private Zone  currentZone;
    private FactorySimulator sim;
    private Zone previousZone;

    public Car(int arrivalMin, int arrivalMax, ZonePair zoneList, String carName, FactorySimulator sim) {
        this.arrivalMin = arrivalMin;
        this.arrivalMax = arrivalMax;
        this.zone = zone;
        this.zoneList = zoneList;
        this.carName = carName;
        this.currentZone=null;
        this.sim=sim;
        this.previousZone=null;

    }

    @Override
    public void handleEvent(double time) {
        System.out.println(carName+"modelo");
        if(counter>zoneList.getZoneId().size()){
            sim.getZoneById(counter-1).removeFromLine();
            return;
        }
        Integer zoneToGo = zoneList.getZoneIdInt(counter);
        Double timeToWait = zoneList.getWaitTimeId(counter);
        System.out.println(zoneList.getZoneId().size()+"=size "+counter+"counter");
        currentZone= sim.getZoneById(zoneToGo);
        if(currentZone.isAvailable()){
            double sample= new GammaDistribution(2,timeToWait).sample();
            sample = sample/2;
            sim.setEvent(sample,this);
            currentZone.occupy();
            if(counter!=1){
                sim.getZoneById(counter-1).removeFromLine();
            }
            counter+=1;

        }


        //need to decrease line counters after leaving a zone   

        else if(!zone.isAvailable()){
            zone.queue(this);
        }





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
