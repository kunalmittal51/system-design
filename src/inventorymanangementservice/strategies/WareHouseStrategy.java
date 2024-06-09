package inventorymanangementservice.strategies;

import inventorymanangementservice.entity.WareHouse;

import java.util.List;

public abstract class WareHouseStrategy {
    public abstract WareHouse selectWareHouse(List<WareHouse> wareHouseList);
}
