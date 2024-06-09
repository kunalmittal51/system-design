package inventorymanangementservice;

import inventorymanangementservice.controller.OrderController;
import inventorymanangementservice.controller.UserController;
import inventorymanangementservice.controller.WareHouseController;
import inventorymanangementservice.entity.Order;
import inventorymanangementservice.entity.User;
import inventorymanangementservice.entity.WareHouse;
import inventorymanangementservice.interfaces.PaymentMode;
import inventorymanangementservice.strategies.WareHouseStrategy;

import java.util.HashMap;

public class OrderManagementService {
    OrderController orderController;
    UserController userController;
    WareHouseController wareHouseController;

    public OrderManagementService(OrderController orderController, UserController userController, WareHouseController wareHouseController) {
        this.orderController = orderController;
        this.userController = userController;
        this.wareHouseController = wareHouseController;
    }

    public OrderController getOrderController() {
        return orderController;
    }


    public UserController getUserController() {
        return userController;
    }


    public WareHouse getWareHouse(WareHouseStrategy wareHouseStrategy) {
        return wareHouseController.getWareHouse(wareHouseStrategy);
    }


    public Order createOrder(User user, WareHouse wareHouse, HashMap<Integer, Integer> productVsQuantity) {
        return orderController.createOrder(user, wareHouse, productVsQuantity);
    }

    public void checkoutOrder(Order order, PaymentMode paymentMode) {
        // validate order in warehouse
        // update inventory
        // make payment
        boolean isSuccessfulPayment = orderController.makePayment(order, paymentMode);
        // if not successful, rollback inventory
    }

    public HashMap<Integer, Integer> buildOrderQuantity() {
        HashMap<Integer, Integer> productVsQuantity = new HashMap<>();
        productVsQuantity.put(1, 3);
        productVsQuantity.put(2, 3);
        return productVsQuantity;
    }


}
