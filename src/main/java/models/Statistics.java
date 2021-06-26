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
            System.out.println("a zona "+zone.getZoneId()+" esteve em operação durante "+(zone.getTotalTimeWorking()*100)/8760+"%");
            listToSend.add("a zona "+String.valueOf(zone.getZoneId())+" esteve em operação durante "+String.valueOf((zone.getTotalTimeWorking()*100)/8760));
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
        //old way
//        int counter =0;
//        double buildTime=0;
//        double waitingTime=0;
//        for(Car car:carDict.get(carId)){
//            buildTime+=car.getTotalTimeToBeBuilt();
//            waitingTime+=car.getTotalWaitingTime();
//            counter++;
//        }
//        System.out.println("o modelo "+carId+" demora em media "+buildTime/counter+" horas");
//        System.out.println("o modelo "+carId+" fica em espera em media"+waitingTime/counter+" horas");
//        return ("o modelo "+carId+" demora em media "+Double.toString(buildTime/counter)+" horas");

        // new way, need to return value, and need to iterate every car
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
        carList.add("o modelo "+pair.getValue().get(0).getCarName()+" demora em media "+Double.toString(buildTime/counter)+" horas");

    }
        return carList;
    }

    public void reset() {
        this.zoneList.clear();
//        this.carDict.clear();

////        Iterator<Map.Entry<String, List<Car>>> it = carDict.entrySet().iterator();
////        while (it.hasNext()) {
////            Map.Entry<String, List<Car>> pair = it.next();
////            pair.getValue().clear();
////            System.out.println(pair.getKey());
////            System.out.println("hi from reset in statistics"+pair.getKey());
//
//        }

    }}

