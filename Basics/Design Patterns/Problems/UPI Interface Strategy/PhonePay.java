import java.lang.Math;
public class PhonePay implements UPIinterface {
    private String CustomerName;
    private String UPIId;
    private int TransId;

    public PhonePay(String customerName, String uPIId) {
        CustomerName = customerName;
        UPIId = uPIId;
    }

    @Override
    public void debit(double amount, String TO) {
        int min = 10000;  
        int max = 99999;  
        this.TransId = (int)(Math.random()*(max-min+1)+min);
        System.out.println("\nTransferred Rs." + amount + " using phonepay. \n\tFrom : " + CustomerName+ " @ " + UPIId + "\n\tTo: "+TO + "\n\tTransaction Id: PHPTN"+TransId);
    }

    @Override
    public void credit(double amount, String From) {
        System.out.println("\nReceived Rs." + amount + " using phonepay. \n\tFrom : " + From);
    }
    
}
