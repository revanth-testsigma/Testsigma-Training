public class CreditCard implements PaymentType {
    
    private String cardNumber;
    private String cardHolderName;

    public CreditCard(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using Credit Card. \n\tCard No: " + cardNumber + " \n\tCard Holder: " + cardHolderName);
    }

    
}
