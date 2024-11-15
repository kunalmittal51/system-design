package carBookingService.entity;

import carBookingService.enums.CarType;

import java.util.*;

public class Branches {
    private String branchId;
    private String branchName;
    private Map<CarType, CarDetails> carDetailsList;

    public Branches(String branchName) {
        this.branchId = UUID.randomUUID().toString();
        this.branchName = branchName;
        this.carDetailsList = new HashMap<>();
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public void setCarDetailsList(Map<CarType, CarDetails> carDetailsList) {
        this.carDetailsList = carDetailsList;
    }

    public String getBranchId() {
        return branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public Map<CarType, CarDetails> getCarDetailsList() {
        return carDetailsList;
    }
}
