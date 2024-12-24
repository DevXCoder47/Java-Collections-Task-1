package com.nikijv.javacollectionsproject1.imitation;
import com.nikijv.javacollectionsproject1.model.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
public class Imitator {
    public LinkedList<Boat> boats;
    public LinkedList<Passenger> passengers;
    private final Random randomizer;
    private final Scanner scanner;
    private static final int HOURS = 18;
    private int average_boat_time;
    private int average_passenger_time;
    private Boat.Stop stop;
    public Imitator() {
        boats = new LinkedList<Boat>();
        passengers = new LinkedList<Passenger>();
        randomizer = new Random();
        scanner = new Scanner(System.in);
    }
    public void imitate() {
        getInputs();
        double average_passenger_time = 0.0;
        int boat_arrival_interval = 0;
        int passenger_count = 0;
        int hours_sum = 0;
        for(int i = 0; i < HOURS; i++){

        }
        reportResults(average_passenger_time, boat_arrival_interval);
    }
    private void reportResults(double average_passenger_time, int boat_arrival_interval){
        System.out.println("Average passenger time in queue - " + (int)average_passenger_time + " hours");
        System.out.println("Boat arrival interval for not overflowing passenger count 5 in queue - " + boat_arrival_interval + " hours");
    }
    private void getInputs(){
        average_boat_time = getAverage("boat");
        average_passenger_time = getAverage("passenger");
        stop = switch(getStopType()){
            case 1 -> Boat.Stop.FINAL;
            case 2 -> Boat.Stop.NON_FINAL;
            default -> null;
        };
    }
    private int getAverage(String object){
        System.out.print("Average " + object + " arrival time: ");
        return scanner.nextInt();
    }
    private int getStopType(){
        while(true) {
            System.out.print("Stop type:\n1. Final \n2. Non-Final\n");
            int input = scanner.nextInt();
            if(input == 1 || input == 2) {
                return input;
            }
        }
    }
}
