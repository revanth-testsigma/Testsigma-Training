// Custom exception for invalid account ID
class InvalidAccountIdException extends Exception {
    public InvalidAccountIdException(String message) {
        super(message);
    }
}

// Custom exception for invalid account type
class InvalidAccountTypeException extends Exception {
    public InvalidAccountTypeException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            BankAccount account1 = new BankAccount(1, BankAccount.AccountType.SAVING, "Revanth", 10000);
            BankAccount account2 = new BankAccount(2, BankAccount.AccountType.CURRENT, "Pavuluri", 20000);

            System.out.println("Before Transactions:");
            System.out.println("Account1: " + account1);
            System.out.println("Account2: " + account2);

            // Credit 5000 to account1 and debit 3000 from account2 using multithreading
            Thread credit = new Transaction(account1, 5000, true);
            Thread debit = new Transaction(account2, 3000, false);

            credit.start();
            debit.start();

            try {
                credit.join();
                debit.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("\nAfter Transactions:");
            System.out.println("Account1: " + account1);
            System.out.println("Account2: " + account2);

        } catch (InvalidAccountIdException | InvalidAccountTypeException e) {
            e.printStackTrace();
        }
    }
}
