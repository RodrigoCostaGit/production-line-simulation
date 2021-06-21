package controller;


import models.Car;
import models.Event;
import models.EventHandler;
import models.Zone;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class FactorySimulator implements Factory {
    //private PriorityQueue<Event> eventTimes = new PriorityQueue<>();
//    private PriorityQueue<Event> eventTimes = new PriorityQueue<>();
    private PriorityQueue<Event> eventTimes = new PriorityQueue<Event>(new EventComparator());
    private double time;
    private List<Car> carList = new ArrayList<Car>();
    private Random random= new Random();
    private List<Zone> zoneList = new ArrayList<Zone>();

    public FactorySimulator() {


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
            System.out.println("one cicle");
            System.out.println("     ");
            this.handleEvent(this.eventTimes.poll());
            if(time>maxTime){
                break;
            }
        }
    }

    @Override
    public void addCar(Car car){
        carList.add(car);
    }

    @Override
    public void queueCarEvents(int time){
        int timerTotal;
        for(Car car:carList){
            int timer=0;
            while(timer<time){
                timer+=random.nextInt(car.getArrivalMax()*24- car.getArrivalMin()*24)+car.getArrivalMin()*24;
                //System.out.println(car.getArrivalMax()+" "+car.getArrivalMin()+" "+timer);
                setEvent(timer,car);
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
                System.out.println(eventTimes.peek().getTime()+" "+eventTimes.peek().getHandler().getArrivalMin()+ " "+eventTimes.peek().getHandler().getArrivalMax());
                eventTimes.poll();
            }
    }

    @Override
    public void addZone(Zone zone){
        this.zoneList.add(zone);
    }

    public Zone getZoneById(int id){
        return zoneList.get(id-1);
    }


}



