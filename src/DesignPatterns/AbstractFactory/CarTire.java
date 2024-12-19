package DesignPatterns.AbstractFactory;

public class CarTire implements Tire{
    @Override
    public void manufacture() {
        System.out.println("manufacturing car tire");
    }
}
