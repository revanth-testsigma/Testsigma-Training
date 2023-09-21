public class Main {
    public static void main(String[] args) {
        

        try {
            BankAccount account = new BankAccount(1000.0, "Revanth Pavuluri");
            account.deposit(500.0);
            System.out.println("Deposited: ₹500.0");
            System.out.println("Current Balance: ₹" + account.getBalance());

            account.withdraw(500.0);
            System.out.println("Withdrawn: ₹500.0");
            System.out.println("Current Balance: ₹" + account.getBalance());

            account.withdraw(200.0);
            System.out.println("Withdrawn: ₹200.0");
            System.out.println("Current Balance: ₹" + account.getBalance());
            
        } catch (AccountException e) {
            System.out.println("AccountException: " + e.getMessage());
        }
    }
}
