package handlenullobject;

import handlenullobject.vehicle.Vehicle;

public class DriverClass {
    public static void main (String[] args) {
        Vehicle vehicle = VehicleFactory.getVehicle("car");
        System.out.println("Car tank capacity: " + vehicle.getTankCapacity());
        System.out.println("Car seat capacity: " + vehicle.getSeatCapacity());


        Vehicle vehicle1 = VehicleFactory.getVehicle("bike");
        System.out.println("Car tank capacity: " + vehicle1.getTankCapacity());
        System.out.println("Car seat capacity: " + vehicle1.getSeatCapacity());
    }
}
