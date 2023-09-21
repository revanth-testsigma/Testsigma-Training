public class Main {
    public static void main(String[] args) {

        PService service = new PService();
    
        // different payment types
        service.setVendor(new PhonePay("Revanth","6304779526@ybl"));
        service.credit(1000,"Sri");
        service.debit(300,"Suji");

        service.setVendor(new GooglePay("Revanth Pavuluri","33revanth@oksbi"));
        service.credit(400,"Sri");
        service.debit(300,"Kee");

        service.setVendor(new Paytm("Revanth","6304779526@paytm"));
        service.credit(5000,"Sri");
        service.debit(3000,"Bhav");
    }
}
