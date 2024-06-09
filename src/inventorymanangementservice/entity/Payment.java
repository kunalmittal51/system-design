package inventorymanangementservice.entity;

import inventorymanangementservice.enums.PaymentStatus;
import inventorymanangementservice.interfaces.PaymentMode;

public class Payment {
    PaymentMode paymentMode;
    PaymentStatus paymentStatus;

    public Payment(PaymentMode paymentMode, PaymentStatus paymentStatus) {
        this.paymentMode = paymentMode;
        this.paymentStatus = paymentStatus;
    }

    public boolean makePayment() {
       return paymentMode.makePayment();
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
