package models;

import java.util.List;

public class ZonePair {
    private List zoneId;
    private List avgTime;


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
}
