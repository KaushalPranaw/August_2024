package DesignPatterns.Factory;

public class Truck implements Vehicle {

    @Override
    public void create() {
        System.out.println("Truck is created");
    }
}
