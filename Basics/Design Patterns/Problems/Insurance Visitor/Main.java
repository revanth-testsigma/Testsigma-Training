public class Main {
    public static void main(String[] args) {
        // Creating insurances
        Policy revLife = new LifeInsurance("Rev",60,"Sri",500000,10,5000,100000000);
        Policy RevHealth = new HealthInsurance("Revanth Pavuluri", 15, "Sri", 50000, 5, 3000, "No");
        Policy RevVec = new VehicleInsurance("Revanth", 25000, 5, 1000, "Bike", "AP 07 eri34");
        // Calculate salaries using the SalaryCalculator visitor
        InsuranceCalculator Calculator = new InsuranceCalculator();
        revLife.accept(Calculator);
        RevHealth.accept(Calculator);
        RevVec.accept(Calculator);
        // Get the total salary
        int totalPolicies = Calculator.getTotalpolicies();
        System.out.println("\nTotal policies" + totalPolicies);
    }
}
