package DesignPatterns.AbstractFactory;

public class BikeFactory implements VehiclePartsFactory {

    @Override
    public Tire createTire() {
        return new BikeTire();
    }

    @Override
    public Engine createEngine() {
        return new BikeEngine();
    }
}
