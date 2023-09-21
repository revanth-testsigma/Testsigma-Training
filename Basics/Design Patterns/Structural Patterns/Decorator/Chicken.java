public class Chicken extends Topping {
    public Chicken(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getCost() {
        return super.getCost() + 100.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", added Chicken";
    }
}
