package inventorymanangementservice.interfaces;

public class CreditCardPayment implements PaymentMode{
    @Override
    public boolean makePayment() {
        System.out.println("Payment made through Credit Card");
        return true;
    }
}
