import java.util.ArrayList;
import java.util.List;
// Bank class to manage multiple BankAccounts
public class Bank {
    private List<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount Account) {
        accounts.add(Account);
    }

    public void deleteAccount(BankAccount Account) {
        accounts.remove(Account);
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }
}
