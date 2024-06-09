package parkinglot.entity;

import parkinglot.enums.VehicleType;

public class Vehicle {
    private VehicleType vehicleType;
    private String registrationNumber;
    private String color;
    private String ticketNumber;
    private Slot slot;

    public Vehicle(String color, String registrationNumber, VehicleType vehicleType) {
        this.color = color;
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
}
