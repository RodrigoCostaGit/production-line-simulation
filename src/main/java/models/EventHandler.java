package models;

public abstract class EventHandler {
    public void handleEvent(double time) {
    }

    public int getArrivalMin(){
        return 1;
    }
    public int getArrivalMax(){
        return 1;
    }

    public String getCarName() {
        return "j";
    }
}
