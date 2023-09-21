//payment strategy
public interface UPIinterface {
    void credit(double amount, String From);
    void debit(double amount, String TO);
}
