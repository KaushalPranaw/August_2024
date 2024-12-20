package DesignPatterns.Creational.AbstractFactory;

public class CarFactory implements VehiclePartsFactory {

    @Override
    public Tire createTire() {
        return new CarTire();
    }

    @Override
    public Engine createEngine() {
        return new CarEngine();
    }
}
