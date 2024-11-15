package carBookingService.entity;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Branches> branchesList;

    public Inventory() {
        this.branchesList = new ArrayList<>();
    }

    public List<Branches> getBranchesList() {
        return branchesList;
    }

    public void setBranchesList(List<Branches> branchesList) {
        this.branchesList = branchesList;
    }
}
