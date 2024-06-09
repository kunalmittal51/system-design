package inventorymanangementservice.controller;

import inventorymanangementservice.entity.Order;
import inventorymanangementservice.entity.Payment;
import inventorymanangementservice.entity.User;
import inventorymanangementservice.entity.WareHouse;
import inventorymanangementservice.enums.PaymentStatus;
import inventorymanangementservice.interfaces.PaymentMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderController {
    HashMap<User, List<Order>> userVsOrders;

    public OrderController() {
        this.userVsOrders = new HashMap<>();
    }

    public List<Order> getOrders(User user) {
        return userVsOrders.get(user);
    }

    public void addUserOrder(User user, Order order) {
        List<Order> orders = userVsOrders.get(user);
        if (orders == null) {
            orders = new ArrayList<>();
        }
        orders.add(order);
        userVsOrders.put(user, orders);
    }

    public Order createOrder(User user, WareHouse wareHouse,HashMap<Integer, Integer> productVsQuantity) {
        Order order = new Order(1, user, wareHouse, productVsQuantity);
        addUserOrder(user, order);
        return order;
    }

    public boolean makePayment(Order order, PaymentMode paymentMode) {
        System.out.println("Making payment for order " + order.getId());
        Payment payment = new Payment(paymentMode, PaymentStatus.INITIATED);
        boolean isSuccessfulPayment = payment.makePayment();
        if (isSuccessfulPayment) {
            System.out.println("Payment Successful for order " + order.getId());
            addUserOrder(order.getUser(), order);
        }
        return isSuccessfulPayment;
    }
}
