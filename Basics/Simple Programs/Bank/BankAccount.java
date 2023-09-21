public class BankAccount {
    enum AccountType {
        SAVING,
        CURRENT
    }

    private int accountId;
    private AccountType accountType;
    private String accountHolderName;
    private double accountBalance;

    public BankAccount(int accountId, AccountType accountType, String accountHolderName, double accountBalance) throws InvalidAccountIdException, InvalidAccountTypeException {
        if (accountId <= 0) {
            throw new InvalidAccountIdException("Invalid Account ID: Account ID must be a positive integer.");
        }

        if (accountType == null) {
            throw new InvalidAccountTypeException("Invalid Account Type: Account type must be specified.");
        }

        this.accountId = accountId;
        this.accountType = accountType;
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
    }

    // Getters and setters (you can generate these methods automatically in IDE)
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "Account ID: " + accountId +
                "\nAccount Type: " + accountType +
                "\nAccount Holder Name: " + accountHolderName +
                "\nAccount Balance: " + accountBalance;
    }
}