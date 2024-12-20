package DesignPatterns.Structural.Bridge;

public class BasicRemote extends RemoteControl {

    public BasicRemote(Device device){
        super(device);
    }

    @Override
    void powerOn() {
        System.out.println("Basic Remote: Turning ON the device");
        device.turnOn();
    }

    @Override
    void powerOff() {
        System.out.println("Basic Remote: Turning OFF the device");
        device.turnOff();
    }
}
