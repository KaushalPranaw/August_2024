package DesignPatterns.AbstractFactory;

public interface VehiclePartsFactory {
    Tire createTire();
    Engine createEngine();
}
