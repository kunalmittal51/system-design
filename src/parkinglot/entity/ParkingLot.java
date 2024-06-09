package parkinglot.entity;

import java.util.List;

public class ParkingLot {
    private String id;
    private int totalFloors;
    private int slotsPerFloor;
    private List<ParkingFloor> parkingFloorList;

    public ParkingLot(String id, int totalFloors, int noOfSlots, List<ParkingFloor> parkingFloorList) {
        this.id = id;
        this.totalFloors = totalFloors;
        this.slotsPerFloor = noOfSlots;
        this.parkingFloorList = parkingFloorList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTotalFloors() {
        return totalFloors;
    }

    public void setTotalFloors(int totalFloors) {
        this.totalFloors = totalFloors;
    }

    public int getSlotsPerFloor() {
        return slotsPerFloor;
    }

    public void setSlotsPerFloor(int slotsPerFloor) {
        this.slotsPerFloor = slotsPerFloor;
    }


    public List<ParkingFloor> getParkingFloorList() {
        return parkingFloorList;
    }

    public void setParkingFloorList(List<ParkingFloor> parkingFloorList) {
        this.parkingFloorList = parkingFloorList;
    }
}
