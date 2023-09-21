public class VehicleInsurance implements Policy {
    private String holdername;
    private int premium;
    private int policyperiod;
    private int term;
    private String Vehicle;
    private String Vehiclenum;


    public VehicleInsurance(String holdername, int premium, int policyperiod, int term, String vehicle,
            String vehiclenum) {
        this.holdername = holdername;
        this.premium = premium;
        this.policyperiod = policyperiod;
        this.term = term;
        Vehicle = vehicle;
        Vehiclenum = vehiclenum;
    }


    public String getHoldername() {
        return holdername;
    }


    public int getPremium() {
        return premium;
    }


    public int getPolicyperiod() {
        return policyperiod;
    }


    public int getTerm() {
        return term;
    }


    public String getVehicle() {
        return Vehicle;
    }


    public String getVehiclenum() {
        return Vehiclenum;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }


    @Override
    public String toString() {
        return "VehicleInsurance [holdername=" + holdername + ", premium=" + premium + ", policyperiod=" + policyperiod
                + ", term=" + term + ", Vehicle=" + Vehicle + ", Vehiclenum=" + Vehiclenum + "]";
    }
}
