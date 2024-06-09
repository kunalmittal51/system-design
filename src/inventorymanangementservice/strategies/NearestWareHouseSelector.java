package inventorymanangementservice.strategies;

import inventorymanangementservice.entity.WareHouse;

import java.util.List;

public class NearestWareHouseSelector extends WareHouseStrategy {
    @Override
    public WareHouse selectWareHouse(List<WareHouse> wareHouseList) {
        // Logic to select nearest warehouse
        if (wareHouseList.isEmpty()) {
            System.out.println("No warehouse available");
            return null;
        }
        return wareHouseList.get(0);
    }
}
