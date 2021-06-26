package models;

import java.util.List;

public class ZonePair {
    private List<Integer> zoneId;
    private List<Double> avgTime;


    public ZonePair(List zoneId, List avgTime) {
        this.zoneId = zoneId;
        this.avgTime = avgTime;
    }

    public List getZoneId() {
        return zoneId;
    }

    public List getAvgTime() {
        return avgTime;
    }

    public int getZoneIdInt(int i){
        return zoneId.get(i-1);
//        return zoneId.get(i);


    }

    public double getWaitTimeId(int i){
//        System.out.println(avgTime.get(i-1));
        return avgTime.get(i-1);
    }
    public void moveUp(){
        ;
    }
    public void moveDown(){
        ;
    }

}
