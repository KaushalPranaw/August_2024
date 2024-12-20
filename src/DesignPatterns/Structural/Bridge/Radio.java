package DesignPatterns.Structural.Bridge;

public class Radio implements Device{
    @Override
    public void turnOn() {
        System.out.println("Radio is now on");
    }

    @Override
    public void turnOff() {
        System.out.println("Radio is now off");
    }
}
