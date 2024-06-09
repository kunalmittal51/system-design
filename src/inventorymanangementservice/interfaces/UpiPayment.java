package inventorymanangementservice.interfaces;

public class UpiPayment implements PaymentMode {
    @Override
    public boolean makePayment() {
        System.out.println("Payment made through UPI");
        return true;
    }
}
