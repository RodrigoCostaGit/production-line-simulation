package controller;

import models.Event;

import java.util.Comparator;

public class EventComparator implements Comparator<Event> {

    @Override
    public int compare(Event s1, Event s2) {
        if (s1.getTime() > s2.getTime())
            return 1;
        else if (s1.getTime() < s2.getTime())
            return -1;
        return 0;
    }
}

