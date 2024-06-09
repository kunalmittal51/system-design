package parkinglot.service;

import parkinglot.entity.ParkingFloor;
import parkinglot.entity.ParkingLot;
import parkinglot.entity.Slot;
import parkinglot.entity.Vehicle;
import parkinglot.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotService {

    // create new parking lot
    public ParkingLot createNewParkingLot(String id, int noOfFloors, int slotsPerFloor) {
        List<ParkingFloor> parkingFloorList =  initializeParkingFloor(noOfFloors, slotsPerFloor);
        return new ParkingLot(id, noOfFloors, slotsPerFloor, parkingFloorList);
    }

    public List<ParkingFloor> initializeParkingFloor(int noOfFloors, int slotsPerFloor) {
        List<ParkingFloor> parkingFloorList = new ArrayList<>();
        for (int i = 0; i < noOfFloors; i++ ) {
            List<Slot> slotList = getSlotList(slotsPerFloor);
            ParkingFloor parkingFloor = new ParkingFloor(i, slotsPerFloor, slotList, i+1);
            parkingFloorList.add(parkingFloor);
        }
        return parkingFloorList;
    }

    public List<Slot> getSlotList(int slotsPerFloor) {
        List<Slot> slotList = new ArrayList<>();
        for (int i = 0 ; i < slotsPerFloor; i++) {
            VehicleType vehicleType;
            if (i%3 == 0) {
                vehicleType = VehicleType.CAR;
            } else if (i%3 == 1) {
                vehicleType = VehicleType.BIKE;
            } else {
                vehicleType = VehicleType.TRUCK;
            }
            Slot slot = new  Slot(i+1, false, vehicleType, null);
            slotList.add(slot);
        }
        return slotList;
    }

    public void displayFreeCount(ParkingLot parkingLot, VehicleType vehicleType){

        for (ParkingFloor parkingFloor : parkingLot.getParkingFloorList()) {
            int freeCount = 0;
            for (Slot slot : parkingFloor.getSlotList()) {
                if (!slot.getIsOccupied() && slot.getVehicleType().equals(vehicleType)) {
                    freeCount++;
                }
            }
            System.out.println("Free slots for " + vehicleType + "on floor " + parkingFloor.getFloorNumber() +  " : " + freeCount);
        }
    }

    public Vehicle parkCar(VehicleType vehicleType, String s, ParkingLot parkingLot, String black) {
        Vehicle vehicle = createVehicle(vehicleType, s, black);
        Slot slot = getFreeSlot(parkingLot, vehicleType);
        if (slot != null) {
            vehicle.setSlot(slot);
            vehicle.setTicketNumber(generateTicketNumber());
            slot.setIsOccupied(true);
            slot.setVehicle(vehicle);
            System.out.println("Vehicle parked at floor: " + slot.getId() + " slot: " + slot.getId());
        } else {
            System.out.println("No free slot available for " + vehicleType);
        }
        return vehicle;
    }

    private String generateTicketNumber() {
        return "TICKET" + System.currentTimeMillis();
    }

    private Slot getFreeSlot(ParkingLot parkingLot, VehicleType vehicleType) {
        for (ParkingFloor parkingFloor : parkingLot.getParkingFloorList()) {
            for (Slot slot : parkingFloor.getSlotList()) {
                if (!slot.getIsOccupied() && slot.getVehicleType().equals(vehicleType)) {
                    return slot;
                }
            }
        }
        return null;
    }

    private Vehicle createVehicle(VehicleType vehicleType, String regNo, String color) {
        return new Vehicle(color, regNo, vehicleType);
    }

    private static class SlotDTO {
        private String flootNumber;
        private String slotNumber;
    }

}
