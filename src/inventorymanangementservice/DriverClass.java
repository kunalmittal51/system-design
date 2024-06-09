package inventorymanangementservice;

import inventorymanangementservice.controller.OrderController;
import inventorymanangementservice.controller.UserController;
import inventorymanangementservice.controller.WareHouseController;
import inventorymanangementservice.entity.*;
import inventorymanangementservice.interfaces.CreditCardPayment;
import inventorymanangementservice.strategies.NearestWareHouseSelector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DriverClass {
    public static void main(String[] args) {
        WareHouseController wareHouseController = initializeWareHouseController();
        System.out.println("WareHouseController initialized successfully");
        UserController userController = initializeUserController();
        System.out.println("UserController initialized successfully");
        OrderController orderController = new OrderController();
        System.out.println("OrderController initialized successfully");

        OrderManagementService orderManagementService = new OrderManagementService(
                orderController, userController, wareHouseController);
        runDemo(orderManagementService, userController.getUser(1));
    }

    private static void runDemo(OrderManagementService orderManagementService, User user) {
        // Get the wareHouse
        WareHouse wareHouse = orderManagementService.getWareHouse(new NearestWareHouseSelector());

        // Display Inventory
        wareHouse.displayInventory();

        // buildOrderQuantity
        HashMap<Integer, Integer> productVsQuantity =  orderManagementService.buildOrderQuantity();

        // Create order
        Order order = orderManagementService.createOrder(user, wareHouse, productVsQuantity);

        // Checkout Order
        orderManagementService.checkoutOrder(order, new CreditCardPayment());

        System.out.println("Order placed successfully");
    }

    private static UserController initializeUserController() {
        UserController userController = new UserController();
        userController.addUser(new User(1, "John"));
        userController.addUser(new User(2, "Mark"));
        userController.addUser(new User(2, "Alice"));
        return userController;
    }

    private static WareHouseController initializeWareHouseController() {
        // We have only one wareHouse for the scope of simplicity
        WareHouse wareHouse = buildWareHouse();
        return new WareHouseController(Collections.singletonList(wareHouse));
    }

    private static WareHouse buildWareHouse() {
        Inventory inventory = buildInventory();
        Address address = new Address("Seattle", "New York", "America");
        return new WareHouse(inventory, address);
    }

    private static Inventory buildInventory() {
        List<ProductCategory> productCategoryList = buildProductCategoryList();
        return new Inventory(productCategoryList);
    }

    private static List<ProductCategory> buildProductCategoryList() {
        List<ProductCategory> productCategoryList = new ArrayList<>();
        ProductCategory productCategory = new ProductCategory(1, "Pepsi");
        productCategory.addProduct(new Product(1, "Pepsi"));
        productCategory.addProduct(new Product(2, "Pepsi"));
        productCategory.addProduct(new Product(3, "Pepsi"));
        productCategory.addProduct(new Product(4, "Pepsi"));
        productCategory.addProduct(new Product(5, "Pepsi"));
        productCategory.setPrice(50);

        ProductCategory productCategory1 = new ProductCategory(2, "Pepsi");
        productCategory1.addProduct(new Product(1, "ThumpsUp"));
        productCategory1.addProduct(new Product(2, "ThumpsUp"));
        productCategory1.addProduct(new Product(3, "ThumpsUp"));
        productCategory1.addProduct(new Product(4, "ThumpsUp"));
        productCategory1.addProduct(new Product(5, "ThumpsUp"));
        productCategory1.setPrice(100);

        productCategoryList.add(productCategory);
        productCategoryList.add(productCategory1);
        return productCategoryList;
    }

}
