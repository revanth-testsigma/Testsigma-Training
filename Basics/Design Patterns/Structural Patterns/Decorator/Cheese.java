public class Cheese extends Topping {
    public Cheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getCost() {
        return super.getCost() + 50.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", added Cheese";
    }
}
