package inventorymanangementservice.controller;

import inventorymanangementservice.entity.WareHouse;
import inventorymanangementservice.strategies.WareHouseStrategy;

import java.util.List;

public class WareHouseController {
    List<WareHouse> wareHouseList;
    WareHouseStrategy wareHouseSelector;

    public WareHouseController(List<WareHouse> wareHouseList) {
        this.wareHouseList = wareHouseList;
    }

    public WareHouse getWareHouse(WareHouseStrategy wareHouseSelector) {
        this.wareHouseSelector = wareHouseSelector;
        return this.wareHouseSelector.selectWareHouse(wareHouseList);
    }

    public void addWareHouse(WareHouse wareHouse) {
        wareHouseList.add(wareHouse);
    }
}
