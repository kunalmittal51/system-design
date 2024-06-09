package parkinglot.entity;

import java.util.List;

public class ParkingFloor {
    private int id;
    private int floorNumber;
    private int capacity;
    private List<Slot> slotList;

    public ParkingFloor(int id, int capacity, List<Slot> slotList, int floorNumber) {
        this.id = id;
        this.capacity = capacity;
        this.slotList = slotList;
        this.floorNumber = floorNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Slot> getSlotList() {
        return slotList;
    }

    public void setSlotList(List<Slot> slotList) {
        this.slotList = slotList;
    }
}
