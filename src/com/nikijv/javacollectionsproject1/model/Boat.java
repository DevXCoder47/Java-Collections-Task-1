package com.nikijv.javacollectionsproject1.model;
public class Boat {
    private final int number;
    private final int free_seats;
    public final Stop stop;
    public enum Stop{
        FINAL,
        NON_FINAL
    }
    public Boat(int number, int free_seats, Stop stop) {
        this.number = number;
        this.free_seats = free_seats;
        this.stop = stop;
    }
    public String toString() {
        return "Boat: " + number + "\nFree Seats: " + free_seats + "\n";
    }
}
