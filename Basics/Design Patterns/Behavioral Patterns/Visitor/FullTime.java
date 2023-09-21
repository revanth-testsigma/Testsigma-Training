public class FullTime implements Employee {
    private String name;
    private int monthlySalary;
    private int tax;
    private int pf;

    public FullTime (String name, int monthlySalary, int tax, int pf) {
        this.name = name;
        this.monthlySalary = monthlySalary;
        this.tax = tax;
        this.pf = pf;
    }

    public int getTax() {
        return tax;
    }

    public int getPf() {
        return pf;
    }

    public String getName() {
        return name;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
