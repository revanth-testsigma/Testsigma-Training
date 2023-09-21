public class InvestorRecord implements Investor {
    private String name;

    public InvestorRecord(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println(name + " received an update for " + stockName + " stock. Price: Rs." + price);
    }
}
