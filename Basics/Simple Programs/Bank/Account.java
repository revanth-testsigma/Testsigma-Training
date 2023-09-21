import java.util.ArrayList;
import java.util.List;
//invalid account ID
class InvalidAccountIdException extends Exception {
    public InvalidAccountIdException(String message) {
        super(message);
    }
}

//invalid account type
class InvalidAccountTypeException extends Exception {
    public InvalidAccountTypeException(String message) {
        super(message);
    }
}

public class Account{
    private int Acc_Id;
    private Acc_Type_lis Acc_Type; 
    private String Acc_HolderName;
    private double Acc_balance;
    public void Create(int Id, Acc_Type_lis Type, String Name, double balance) throws InvalidAccountIdException, InvalidAccountTypeException {
        if (Id <= 0) {
            throw new InvalidAccountIdException("Invalid Account ID: Must be a positive integer.");
        }

        if (Type == null) {
            throw new InvalidAccountTypeException("Invalid Account Type: Must be specified.");
        }
        this.Acc_Id = Id;
        this.Acc_HolderName = Name;
        this.Acc_Type = Type;
        this.Acc_balance = balance;
        System.out.println("Account created successfully.");
        Display();
    }
    void Deposit(double Amount){
        Acc_balance = Acc_balance+Amount;
        System.out.println("Amount of Rs."+Amount+" deposited in "+Acc_HolderName+"\'s account.");
    }
    void Withdraw(double Amount){
        if(Acc_balance < Amount){
            System.out.println("Insufficient balance in "+Acc_HolderName+"\'s account.");
        }
        else{
            Acc_balance = Acc_balance - Amount;
            System.out.println("Amount of Rs."+Amount+" withdrawn in "+Acc_HolderName+"\'s account.");
        }
    }
    double Balance(){
        System.out.println("Balance in "+Acc_HolderName+"\'s account is Rs."+Acc_balance);
        return Acc_balance;
    }
    void Display(){
        System.out.println("Account Details : \n Account number = "+Acc_Id+"\n Account type = "+Acc_Type+" \n Account holder name = "+ Acc_HolderName+"\n Balance = "+Acc_balance);
    }
    boolean Search(String Acc_Id) {  
        if (Acc_Id.equals(Acc_Id)) {  
            Display();  
            return (true);  
        }  
        return (false);  
    }
}
class Bank {
    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void deleteAccount(Account account) {
        accounts.remove(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}