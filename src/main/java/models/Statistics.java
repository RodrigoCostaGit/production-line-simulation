package models;

import java.util.*;

public class Statistics {
    private Map<String,List<Car>> carDict = new HashMap<String,List<Car>>();
    private List<Zone> zoneList = new ArrayList<Zone>();


    public Statistics(){

    }

    public void addZone(Zone zone){
        zoneList.add(zone);
    }

    public List getStatsZone(){
        List listToSend = new ArrayList();
        for(Zone zone:zoneList){
//            System.out.println("a zona "+zone.getZoneId()+" esteve em operação durante "+(zone.getTotalTimeWorking()*100)/8760+"%");
            listToSend.add("a zona "+String.valueOf(zone.getZoneId())+" esteve em operação durante "+String.valueOf((zone.getTotalTimeWorking()*100)/8760)+"%");
        }
        return listToSend;
    }

    public void addCarModel(String name){
        List<Car> lista = new ArrayList<Car>();
        carDict.put(name,lista);
    }

    public void addCar(Car car){
        String name = car.getCarName();
        carDict.get(name).add(car);
    }

    public List getStats(){
        List carList = new ArrayList();
        Iterator<Map.Entry<String,List<Car>>> it = carDict.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,List<Car>> pair = it.next();
        int counter =0;
        double buildTime=0;
        double waitingTime=0;
        for(Car car:pair.getValue()){
            buildTime+=car.getTotalTimeToBeBuilt();
            waitingTime+=car.getTotalWaitingTime();
            counter++;
        }
        try{
            carList.add("o modelo "+pair.getValue().get(0).getCarName()+" demora em média "+Double.toString(buildTime/counter)+" horas");
            carList.add("o modelo "+pair.getValue().get(0).getCarName()+" fica a espera em média "+Double.toString(waitingTime/counter)+" horas");

        }
        catch (IndexOutOfBoundsException e){
            System.out.println(pair.getKey()+"try catch block");
            System.out.println(pair.getValue());
        }

    }
        return carList;
    }


    }

