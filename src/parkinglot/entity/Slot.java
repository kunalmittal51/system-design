package parkinglot.entity;

import parkinglot.enums.VehicleType;

public class Slot {
    private int id;
    private boolean isOccupied;
    private VehicleType vehicleType;
    private Vehicle vehicle;

    public Slot(int id, boolean isOccupied, VehicleType vehicleType, Vehicle vehicle) {
        this.id = id;
        this.isOccupied = isOccupied;
        this.vehicleType = vehicleType;
        this.vehicle = vehicle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
