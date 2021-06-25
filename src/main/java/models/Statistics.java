package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private Map<String,List<Car>> carDict = new HashMap<String,List<Car>>();
    private List<Zone> zoneList = new ArrayList<Zone>();


    public Statistics(){

    }

    public void addZone(Zone zone){
        zoneList.add(zone);
    }

    public void getStatsZone(){
        for(Zone zone:zoneList){
            System.out.println("a zona "+zone.getZoneId()+" esteve em operação durante "+(zone.getTotalTimeWorking()*100)/8760+"%");
        }
    }

    public void addCarModel(String name){
        List<Car> lista = new ArrayList<Car>();
        carDict.put(name,lista);
    }

    public void addCar(Car car){
        String name = car.getCarName();
        carDict.get(name).add(car);
    }

    public String getStats(String carId){
        int counter =0;
        double buildTime=0;
        double waitingTime=0;
        for(Car car:carDict.get(carId)){
            buildTime+=car.getTotalTimeToBeBuilt();
            waitingTime+=car.getTotalWaitingTime();
            counter++;
        }
        System.out.println("o modelo "+carId+" demora em media "+buildTime/counter+" horas");
        System.out.println("o modelo "+carId+" fica em espera em media"+waitingTime/counter+" horas");
        return ("o modelo "+carId+" demora em media "+Double.toString(buildTime/counter)+" horas");

    }


}
