package DesignPatterns.Creational.Factory;

public class SUV implements Vehicle {

    @Override
    public void create() {
        System.out.println("SUV is created");
    }
}
