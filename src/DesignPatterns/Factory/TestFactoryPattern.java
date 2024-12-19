package DesignPatterns.Factory;

public class TestFactoryPattern {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();
        Vehicle vehicle=vehicleFactory.getVehicle("suv");
        vehicle.create();
    }
}
