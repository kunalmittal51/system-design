package carBookingService.service;

import carBookingService.entity.Branches;
import carBookingService.entity.Car;
import carBookingService.entity.CarDetails;
import carBookingService.entity.Inventory;
import carBookingService.enums.CarType;

import java.util.List;

public class InventoryService {
    Inventory inventory;

    public InventoryService() {
        this.inventory = new Inventory();
    }

    public void addBranches(String branchName) {
        List<Branches> branchesList = inventory.getBranchesList();
        if (branchesList.stream().noneMatch(branches -> branches.getBranchName().equals(branchName))) {
            Branches branch = new Branches(branchName);
            branchesList.add(branch);
            inventory.setBranchesList(branchesList);
        }
    }

    public void addPrice(String branchName, CarType carType, Integer price) {
        List<Branches> branchesList = inventory.getBranchesList();
        for (Branches branch : branchesList) {
            if (branch.getBranchName().equals(branchName)) {
                CarDetails carDetails = branch.getCarDetailsList().getOrDefault(carType, new CarDetails());
                carDetails.setPrice(price);
                branch.getCarDetailsList().put(carType, carDetails);
                return;
            } else {
                throw new IllegalArgumentException("Branch not found for branch name: " + branchName);
            }
        }
    }

    public void addCar(String carNumber, CarType carType, String branchName, Integer price) {
        List<Branches> branchesList = inventory.getBranchesList();
        for (Branches branch : branchesList) {
            if (branch.getBranchName().equals(branchName)) {
                Car car = new Car(carNumber);
                CarDetails carDetails = branch.getCarDetailsList().getOrDefault(carType, new CarDetails());
                carDetails.getCarList().add(car);
                carDetails.setPrice(price);
                branch.getCarDetailsList().put(carType, carDetails);
                return;
            } else {
                throw new IllegalArgumentException("Branch not found for branch name: " + branchName);
            }
        }
    }
}
