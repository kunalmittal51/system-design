package inventorymanangementservice.strategies;

import inventorymanangementservice.controller.OrderController;
import inventorymanangementservice.controller.UserController;
import inventorymanangementservice.controller.WareHouseController;

public class OrderManagementService {
    UserController userController;
    WareHouseController wareHouseController;
    OrderController orderController;

    public OrderManagementService(UserController userController,
                                  WareHouseController wareHouseController,
                                  OrderController orderController) {
        this.userController = userController;
        this.wareHouseController = wareHouseController;
        this.orderController = orderController;
    }
}
