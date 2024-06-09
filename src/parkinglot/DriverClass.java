package parkinglot;

import parkinglot.entity.ParkingLot;
import parkinglot.enums.VehicleType;
import parkinglot.service.ParkingLotService;

public class DriverClass {
    public static void main(String[] args) {
        ParkingLotService parkingLotService = new ParkingLotService();
        ParkingLot parkingLot = parkingLotService.createNewParkingLot("PARK123", 2, 10);
        System.out.println("Parking lot created with id: " + parkingLot.getId());
        parkingLotService.displayFreeCount(parkingLot, VehicleType.CAR);
        parkingLotService.displayFreeCount(parkingLot, VehicleType.BIKE);
        parkingLotService.displayFreeCount(parkingLot, VehicleType.TRUCK);

        parkingLotService.parkCar(VehicleType.CAR, "KA-01-HH-1234", parkingLot, "black");
        parkingLotService.parkCar(VehicleType.TRUCK, "KA-01-HH-1235", parkingLot, "blue");
        parkingLotService.parkCar(VehicleType.BIKE, "KA-01-HH-1235", parkingLot, "black");
        parkingLotService.parkCar(VehicleType.CAR, "KA-01-HH-1235", parkingLot, "black");
        System.out.println("Parking lot created with id: " + parkingLot);
    }
}
