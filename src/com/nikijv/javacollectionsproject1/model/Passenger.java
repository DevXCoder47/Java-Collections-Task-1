package com.nikijv.javacollectionsproject1.model;
public class Passenger {
    private final String name;
    public int hours_waited = 0;
    public Passenger(String name) {
        this.name = name;
    }
    public String toString() {
        return "Passenger: " + name;
    }
}
