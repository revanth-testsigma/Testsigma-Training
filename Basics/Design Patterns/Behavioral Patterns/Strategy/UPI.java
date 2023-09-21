public class UPI implements PaymentType {
    
    private String UPIID;
    private String App;

    public UPI(String UPIID, String App) {
        this.UPIID = UPIID;
        this.App = App;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using UPI. \n\tUPI ID: " + UPIID + " \n\tProvider: " + App);
    }

    
}
