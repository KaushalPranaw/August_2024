package DesignPatterns.Factory;

public class Sedan implements Vehicle {

    @Override
    public void create() {
        System.out.println("Sedan is created");
    }
}
