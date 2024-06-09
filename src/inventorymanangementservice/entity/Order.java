package inventorymanangementservice.entity;

import inventorymanangementservice.enums.OrderStatus;

import java.util.HashMap;

public class Order {
    int id;
    User user;
    Address deliveryAddress;
    WareHouse wareHouse;
    Invoice invoice;
    Payment payment;
    OrderStatus orderStatus;
    HashMap<Integer, Integer> productCategoryVsQuantity;

    public Order(int id, User user, WareHouse wareHouse, HashMap<Integer, Integer> productCategoryVsQuantity) {
        this.id = id;
        this.user = user;
        this.wareHouse = wareHouse;
        this.productCategoryVsQuantity = productCategoryVsQuantity;
        this.orderStatus = OrderStatus.PLACED;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public WareHouse getWareHouse() {
        return wareHouse;
    }

    public void setWareHouse(WareHouse wareHouse) {
        this.wareHouse = wareHouse;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public HashMap<Integer, Integer> getProductCategoryVsQuantity() {
        return productCategoryVsQuantity;
    }

    public void setProductCategoryVsQuantity(HashMap<Integer, Integer> productCategoryVsQuantity) {
        this.productCategoryVsQuantity = productCategoryVsQuantity;
    }
}
