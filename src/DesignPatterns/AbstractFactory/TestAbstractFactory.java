package DesignPatterns.AbstractFactory;

public class TestAbstractFactory {
    public static void main(String[] args) {
        VehiclePartsFactory carFactory = new CarFactory();
        Engine carEngine = carFactory.createEngine();
        Tire carTire = carFactory.createTire();
        carTire.manufacture();
        carEngine.design();

        VehiclePartsFactory bikeFactory = new BikeFactory();
        Engine bikeEngine = bikeFactory.createEngine();
        Tire bikeTire = bikeFactory.createTire();
        bikeEngine.design(); // Output: Designing a Bike Engine!
        bikeTire.manufacture(); // Output: Manufacturing a Bike Tire!
    }
}
