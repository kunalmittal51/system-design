package elevator;

import elevator.entity.Building;
import elevator.entity.Floor;

import java.util.ArrayList;
import java.util.List;

public class DriverClass {
    public static void main(String[] args) {
        Building building = initializeBuilding();
        Floor floor = building.getFloorList().get(0);
    }

    private static Building initializeBuilding() {
        int numberOfFloors = 10;
        List<Floor> floorList = initializeFloors(numberOfFloors);
        return new Building("Office", floorList);
    }

    private static List<Floor> initializeFloors(int noOfFloors) {
        List<Floor> floorList = new ArrayList<>();
        for (int i = 0; i < noOfFloors; i++) {
            Floor floor = new Floor(i);
            floorList.add(floor);
        }
        return floorList;
    }
}
