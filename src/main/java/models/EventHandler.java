package models;

public interface EventHandler {
    default void handleEvent(double time) {
    }

}
