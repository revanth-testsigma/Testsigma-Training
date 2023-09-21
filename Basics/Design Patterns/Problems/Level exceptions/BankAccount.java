public class BankAccount {
    private double balance;
    private String Holder;

    public BankAccount(double balance, String holder) throws AccountException{
        if (balance < 1000) {
            throw new AccountException("Invalid minimum balance amount.");
        }
        this.balance = balance;
        this.Holder = holder;
    }

    public void deposit(double amount) throws AccountException {
        if (amount <= 0) {
            throw new InvalidTransactionException("Invalid deposit amount.");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws AccountException {
        if (amount <= 0) {
            throw new InvalidTransactionException("Invalid withdrawal amount.");
        }

        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds to withdraw.");
        }

        // transaction failure scenario
        if (Math.random() < 0.1) {
            throw new TransactionFailedException("Transaction failed. Please try again later.");
        }

        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
