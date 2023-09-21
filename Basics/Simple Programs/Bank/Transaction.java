class Transaction extends Thread {
    private BankAccount bankAccount;
    private double amount;
    private boolean TrType;

    public Transaction(BankAccount bankAccount, double amount, boolean TrType) {
        this.bankAccount = bankAccount;
        this.amount = amount;
        this.TrType = TrType;
    }

    @Override
    public void run() {
        if (TrType) {
            synchronized (bankAccount) {
                bankAccount.setAccountBalance(bankAccount.getAccountBalance() + amount);
            }
        } else {
            synchronized (bankAccount) {
                if (bankAccount.getAccountBalance() >= amount) {
                    bankAccount.setAccountBalance(bankAccount.getAccountBalance() - amount);
                } else {
                    System.out.println("Insufficient balance for debit operation!");
                }
            }
        }
    }
}
