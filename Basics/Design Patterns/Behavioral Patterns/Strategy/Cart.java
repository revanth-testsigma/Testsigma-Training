public class Cart {
    private PaymentType payment;

    public void setPaymentType(PaymentType payment) {
        this.payment = payment;
    }

    public void checkout(double totalAmount) {
        payment.pay(totalAmount);
    }
}
