package DesignPatterns.Creational.AbstractFactory;

public interface VehiclePartsFactory {
    Tire createTire();
    Engine createEngine();
}
