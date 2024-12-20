package DesignPatterns.Structural.Bridge;

public class TV implements Device{
    @Override
    public void turnOn() {
        System.out.println("Tv is now on");
    }

    @Override
    public void turnOff() {
        System.out.println("Tv is now off");
    }
}
