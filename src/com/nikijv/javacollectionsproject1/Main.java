package com.nikijv.javacollectionsproject1;
import com.nikijv.javacollectionsproject1.imitation.Imitator;
public class Main {
    public static void main(String[] args) {
        Imitator imitator = new Imitator();
        imitator.imitate();
        imitator.scanner.close();
    }
}
