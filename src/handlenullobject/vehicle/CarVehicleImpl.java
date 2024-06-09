package handlenullobject.vehicle;

public class CarVehicleImpl implements Vehicle {
    @Override
    public int getTankCapacity() {
        return 50;
    }

    @Override
    public int getSeatCapacity() {
        return 40;
    }
}
