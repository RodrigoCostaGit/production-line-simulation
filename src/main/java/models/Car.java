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
    private double startTime;
    private double totalTimeToBeBuilt=0;
    private double totalWaitingTime=0;
    private double TimeWaiting=0;
    private double timeWaitingHolder;
    private static int nameCounter =1;


    public Car(int arrivalMin, int arrivalMax, ZonePair zoneList,String carName, FactorySimulator sim) {
        this.arrivalMin = arrivalMin;
        this.arrivalMax = arrivalMax;
        this.zone = zone;
        this.zoneList = zoneList;
        this.carName = carName;
        this.currentZone=null;
        this.sim=sim;




    }

//    //todo: add statistics
//    //todo:average time for car to be built
//    //todo:
//    @Override
//    public void handleEvent(double time) {
//        System.out.println(" ");
//        System.out.println("modelo: "+carName+" current time:"+time);
//        System.out.println("");
//        //checks if it reached the end of the factory,
//        //todo: add a way to make queued up cars in zones waiting go off and set a event
//        if(counter>zoneList.getZoneId().size()){
//            Integer zoneToGo = zoneList.getZoneIdInt(counter-1);
//            sim.getZoneById(zoneToGo).removeFromLine(time);
//            System.out.println("finished production of car model "+carName);
//            sim.stats.add("carro com object id:"+this.getCarName()+" acabou a produção a "+time);
//            return;
//        }
//
//        //zoneToGo timetowait self explanatory
//        Integer zoneToGo = zoneList.getZoneIdInt(counter);
//        Double timeToWait = zoneList.getWaitTimeId(counter);
//        //System.out.println(zoneList.getZoneId().size()+"=size "+counter+"counter");
//        currentZone= sim.getZoneById(zoneToGo);
//        //checks if zone is available
//        if(currentZone.isAvailable()){
//            System.out.println("car model sent to production on line"+currentZone.getZoneId());
//            //2 erlang time distribution
//            double sample= new GammaDistribution(2,timeToWait).sample();
//            //tbh not sure why i have to divide by 2, it works, not complaining
//            sample = sample/2;
//            System.out.println("car will take "+sample+" hours on the production line");
//            //sets a new event with this object
//            sim.setEvent(time+sample,this);
//            //ocupies the zone
//            currentZone.occupy();
//            //not pretty, basically checks if its not the first order, if its not it clears a line from the previous zone
//            if(counter!=1){
//                sim.getZoneById(zoneList.getZoneIdInt(counter-1)).removeFromLine(time);
//            }
//            counter+=1;
//
//        }
//        //need to decrease line counters after leaving a zone
//
//        else if(!currentZone.isAvailable()){
//            System.out.println("zone is unavailable, car entered zone queue ");
//            currentZone.queue(this);
//        }


        //no print version
        @Override
        public void handleEvent(double time) {
            if(counter==1){
                startTime=time;
                System.out.println(this.carName+" entered production");
            }
            //checks if it reached the end of the factory,
            if(counter>zoneList.getZoneId().size()){
                Integer zoneToGo = zoneList.getZoneIdInt(counter-1);
                sim.getZoneById(zoneToGo).removeFromLine(time);
                sim.stats.add("carro com object id:"+this.getCarName()+" acabou a produção a "+time);
                sim.getStatistics().addCar(this);
                totalTimeToBeBuilt=time-startTime;
                System.out.println(this.carName+" finished production");
                return;
            }
            //zoneToGo timetowait self explanator
            Integer zoneToGo = zoneList.getZoneIdInt(counter);
            Double timeToWait = zoneList.getWaitTimeId(counter);
            //System.out.println(zoneList.getZoneId().size()+"=size "+counter+"counter");
            currentZone= sim.getZoneById(zoneToGo);
            //checks if zone is available
            if(currentZone.isAvailable()){
                //2 erlang time distribution
                double sample= new GammaDistribution(2,timeToWait).sample();
                //tbh not sure why i have to divide by 2, it works, not complaining
                sample = sample/2;
                //sets a new event with this object
                sim.setEvent(time+sample,this);
                //ocupies the zone
                currentZone.occupy(time);
                //not pretty, basically checks if its not the first order, if its not it clears a line from the previous zone
                if(counter!=1){
                    sim.getZoneById(zoneList.getZoneIdInt(counter-1)).removeFromLine(time);
                }
                System.out.println(this.carName+" sent to zone "+zoneList.getZoneIdInt(counter));
                counter+=1;

            }
            //need to decrease line counters after leaving a zone

            else if(!currentZone.isAvailable()){
                currentZone.queue(this);
                timeWaitingHolder=time;
                System.out.println(this.carName+" couldnt enter the zone, not available, queued up");



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

    @Override
    public String getCarName() {
        return carName;
    }

    public void addWaitingTime(Double time){
        totalWaitingTime+=time-timeWaitingHolder;
    }

    public double getTotalTimeToBeBuilt(){
        return totalTimeToBeBuilt;
    }

    public double getTotalWaitingTime(){
        return totalWaitingTime;
    }

}
