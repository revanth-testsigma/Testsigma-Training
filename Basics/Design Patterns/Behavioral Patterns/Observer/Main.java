public class Main {
    public static void main(String[] args) {
        // Creating stocks and investors
        StockMarket zomatoStock = new StockMarket("Zomato", 100.0);
        StockMarket GoogleStock = new StockMarket("Google", 10000.0);
        
        Investor Prav = new InvestorRecord("Prav");
        Investor Rev = new InvestorRecord("Revanth");

        // Register investors with the stock market
        zomatoStock.registerInvestor(Prav);
        zomatoStock.registerInvestor(Rev);

        GoogleStock.registerInvestor(Rev);

        // Simulate stock price changes
        zomatoStock.setStockPrice(105.0);

        System.out.println("-------------------------");

        GoogleStock.setStockPrice(100000.0);
    }
}
