public class PService {
    private UPIinterface payment;

    public void setVendor(UPIinterface payment) {
        this.payment = payment;
    }

    public void debit(double totalAmount, String TO) {
        payment.debit(totalAmount, TO);
    }
    public void credit(double totalAmount, String From) {
        payment.credit(totalAmount, From);
    }
}
