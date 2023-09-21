public class InsuranceCalculator implements Visitor {
    private int totalPolicies;

    @Override
    public void visit(LifeInsurance policy) {
        System.out.println("\nLife Insurance Policy details ");
        System.out.println(policy);
        totalPolicies += 1; 
    }

    @Override
    public void visit(HealthInsurance policy) {
        System.out.println("\nHealth Insurance Policy details ");
        System.out.println(policy);
        totalPolicies += 1; 
    }

    @Override
    public void visit(VehicleInsurance policy) {
         System.out.println("\nVehicle Insurance Policy details ");
        System.out.println(policy);
        totalPolicies += 1; 
    }

    public int getTotalpolicies() {
        return totalPolicies;
    }
}
