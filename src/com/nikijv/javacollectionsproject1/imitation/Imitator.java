package com.nikijv.javacollectionsproject1.imitation;
import com.nikijv.javacollectionsproject1.model.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
public class Imitator {
    public enum Stop{
        FINAL,
        NON_FINAL
    }
    public LinkedList<Passenger> passengers;
    private final Random randomizer;
    private final Scanner scanner;
    private static final int HOURS = 18;
    private int average_boat_arrival_time;
    private int average_passenger_arrival_time;
    private Stop stop;
    public Imitator() {
        passengers = new LinkedList<Passenger>();
        randomizer = new Random();
        scanner = new Scanner(System.in);
    }
    public void imitate() {
        getInputs();
        double average_passenger_time = 0;
        int boat_arrival_interval = 0;
        double passenger_count = 0;
        int current_passenger_count = 0;
        double hours_sum = 0;
        for(int i = 0; i < HOURS; i++){
            if(i % average_passenger_arrival_time == 0) {
                Passenger passenger = new Passenger("PName " + i);
                passengers.add(passenger);
                System.out.println("Passenger " + passenger + " came");
                passenger_count++;
                current_passenger_count++;
            }
            if(i % average_boat_arrival_time == 0){
                int free_seats = randomizer.nextInt(0, 6);
                System.out.println("Boat arrived. Stop is " + stop + ". Free seats - " + free_seats);
                if(current_passenger_count <= 5)
                    boat_arrival_interval = average_boat_arrival_time;
                for(int j = 0; j < free_seats; j++){
                    if(passengers.isEmpty())
                        break;
                    Passenger passenger = passengers.removeFirst();
                    hours_sum += passenger.hours_waited;
                    current_passenger_count--;
                }
                if(!passengers.isEmpty())
                    for(Passenger passenger : passengers)
                        passenger.hours_waited++;
            }
        }
        average_passenger_time = hours_sum / passenger_count;
        reportResults(average_passenger_time, boat_arrival_interval);
    }
    private void reportResults(double average_passenger_time, int boat_arrival_interval){
        System.out.println("Average passenger time in queue - " + average_passenger_time + " hours");
        System.out.println("Boat arrival interval for not overflowing passenger count 5 in queue - " + boat_arrival_interval + " hours");
    }
    private void getInputs(){
        average_boat_arrival_time = getAverage("boat");
        average_passenger_arrival_time = getAverage("passenger");
        stop = switch(getStopType()){
            case 1 -> Stop.FINAL;
            case 2 -> Stop.NON_FINAL;
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
