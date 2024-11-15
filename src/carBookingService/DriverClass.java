package carBookingService;

import carBookingService.enums.CarType;
import carBookingService.service.InventoryService;

public class DriverClass {
    public static void main(String[] args) {
        InventoryService inventoryService = new InventoryService();
        inventoryService.addBranches("Branch1");
        inventoryService.addBranches("Branch2");
        inventoryService.addBranches("Branch3");
        inventoryService.addBranches("Branch4");

        inventoryService.addPrice("Branch1", CarType.SEDAN, 10000);
        inventoryService.addPrice("Branch1", CarType.HATCHBACK, 8000);
        inventoryService.addCar("KA-01-HH-1234", CarType.SEDAN, "Branch1", 10000);

        System.out.println("hello");
    }
}
