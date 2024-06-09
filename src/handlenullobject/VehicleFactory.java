package handlenullobject;

import handlenullobject.vehicle.CarVehicleImpl;
import handlenullobject.vehicle.NullVehicleImpl;
import handlenullobject.vehicle.Vehicle;

public class VehicleFactory {
    public static Vehicle getVehicle(String vehicleType) {
        if (vehicleType.equalsIgnoreCase("car")) {
            return new CarVehicleImpl();
        }
        return new NullVehicleImpl();
    }
}
