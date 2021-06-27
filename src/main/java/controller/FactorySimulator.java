package controller;


import javafx.concurrent.Task;
import models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class FactorySimulator implements Factory,Runnable {
    //private PriorityQueue<Event> eventTimes = new PriorityQueue<>();
//    private PriorityQueue<Event> eventTimes = new PriorityQueue<>();
    public PriorityQueue<Event> eventTimes = new PriorityQueue<Event>(new EventComparator());
    private double time;
    private List<List> carList = new ArrayList<>();
    private Random random= new Random();
    private List<Zone> zoneList = new ArrayList<Zone>();
    public List stats = new ArrayList();
    private Statistics stats1 = new Statistics();
    private int maxTime;

    public FactorySimulator() {


    }


    public double getTime(){
        return time;
    }

    @Override
    public void setEvent(double time, EventHandler handler){
        this.eventTimes.add(new Event(time,handler));
    }

    @Override
    public void handleEvent(Event e){
        this.time=e.getTime();
        if(e.getHandler()!=null){
            e.getHandler().handleEvent(this.time);
        }
    }

//    @Override
//    public void run(double maxTime){
//        while(time<maxTime){
//            this.handleEvent(this.eventTimes.poll());
//        }
//
//
//    }

    @Override
    public void run(int maxTime) {
        while (!this.eventTimes.isEmpty()) {
            this.handleEvent(this.eventTimes.poll());
            if(time>maxTime){
                System.out.println("finished sim");
//                for(Zone zone:zoneList){
//                    zone.finish(maxTime);
//                }
                break;
            }
        }

    }

//    @Override
//    public void addCar(Car car){
//        carList.add(car);
//    }

    @Override
    public void addCar(int arrivalMin, int arrivalMax, ZonePair zoneList, String carName){
        List lista = new ArrayList();
        lista.add(arrivalMin);
        lista.add(arrivalMax);
        lista.add(zoneList);
        lista.add(carName);
        carList.add(lista);
        stats1.addCarModel(carName);
    }

    @Override
    public void queueCarEvents(int time){
        int timerTotal;
        for(Object car:carList){
            List car2 =(List)car;
            int arrivalMax =(int)car2.get(1);
            int arrivalMin =(int)car2.get(0);
            ZonePair zonepair =(ZonePair)car2.get(2);
            String carName =(String)car2.get(3);
            int timer=0;
            while(timer<time){
                timer+=random.nextInt(arrivalMax*24- arrivalMin*24)+arrivalMin*24;
                //System.out.println(car.getArrivalMax()+" "+car.getArrivalMin()+" "+timer);
                Car carToAdd =new Car(arrivalMax,arrivalMin,zonepair,carName,this);
                setEvent(timer,carToAdd);
            }
        }
    }
    public void testclass(){
//        for(Event event:eventTimes){
//            return event.getTime();
//        }
//        return 0;
            while(!eventTimes.isEmpty()){
//                System.out.println(eventTimes.remove().getTime());
                System.out.println(eventTimes.peek().getTime()+" "+eventTimes.peek().getHandler().getCarName());
                eventTimes.poll();
            }
    }

    @Override
    public void addZone(Zone zone){
        this.zoneList.add(zone);
        this.stats1.addZone(zone);
    }

    public Zone getZoneById(int id){
        return zoneList.get(id-1);
    }



    public Statistics getStatistics(){
        return stats1;
    }

    public String printt(){
        return "hi bitch";
    }

    public void setMaxTime(int maxTime){
        this.maxTime=maxTime;
    }


    public List<Zone> getZoneList(){
        return zoneList;
    }

    public void resetStats(){
        this.stats1=new Statistics();
        for(List car:carList){
            String name = (String) car.get(3);
            stats1.addCarModel(name);
        }
        for(Zone zone:zoneList){
            zone.resetTime();
            zone.resetLineCounter();
            stats1.addZone(zone);
        }

    }

    @Override
    public void run() {
        while (!this.eventTimes.isEmpty()) {
            this.handleEvent(this.eventTimes.poll());
            if(time>maxTime){
                System.out.println("finished sim");
//                for(Zone zone:zoneList){
//                    zone.finish(maxTime);
//                }
                break;
            }
        }

    }

    public List<List> getCar(){
        return this.carList;
    }

    public void deleteCar(String name){
        carList.removeIf(b->b.get(3).equals(name));
//        for(List<List> car:carList){
//            if(car.get(3).equals(name)){
//
//            };
//
//        }
    }

}



