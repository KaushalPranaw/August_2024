package DesignPatterns.Creational.AbstractFactory;

public class BikeTire implements Tire{
    @Override
    public void manufacture() {
        System.out.println("manufacturing bike tire");
    }
}
