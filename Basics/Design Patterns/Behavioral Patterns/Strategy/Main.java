public class Main {
    public static void main(String[] args) {

        Cart cart = new Cart();

        // lets say the total amount of items in checkout
        double totalAmount = 150.0;

        // different payment types for checkout
        cart.setPaymentType(new CreditCard("1234 5678 9012 3456", "Revanth Pavuluri"));
        cart.checkout(totalAmount);

        cart.setPaymentType(new UPI("6304779526@ybl", "Phone Pay"));
        cart.checkout(totalAmount);
    }
}
