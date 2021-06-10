package models;

import java.util.List;
import java.util.concurrent.ThreadFactory;

public class zone implements ThreadFactory {
    private int numLines;

    public zone(int numLines){
        this.numLines = numLines;
    }



    @Override
    public Thread newThread(Runnable r) {
        return null;
    }
}
