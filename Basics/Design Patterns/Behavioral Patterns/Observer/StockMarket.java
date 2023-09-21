import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private String stockName;
    private double price;
    private List<Investor> investors;

    public StockMarket(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
        this.investors = new ArrayList<>();
    }

    @Override
    public void registerInvestor(Investor investor) {
        investors.add(investor);
    }

    @Override
    public void removeInvestor(Investor investor) {
        investors.remove(investor);
    }

    @Override
    public void notifyInvestors() {
        for (Investor investor : investors) {
            investor.update(stockName, price);
        }
    }

    // Method to simulate changes in stock price
    public void setStockPrice(double newPrice) {
        this.price = newPrice;
        notifyInvestors();
    }
}
