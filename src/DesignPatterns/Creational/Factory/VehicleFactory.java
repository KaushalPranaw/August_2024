package DesignPatterns.Creational.Factory;

public class VehicleFactory {
    public Vehicle getVehicle(String vehicleType) {
        switch (vehicleType) {
            case "sedan" -> {
                return new Sedan();
            }
            case "suv" -> {
                return new SUV();
            }
            case "truck" -> {
                return new Truck();
            }
            default -> {
                return null; // Handle unknown vehicle types
            }
        }
    }
}
