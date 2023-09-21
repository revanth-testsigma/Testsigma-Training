public class HealthInsurance implements Policy {
    
    private String holdername;
    private int spanassured;
    private String nomiee;
    private int premium;
    private int policyperiod;
    private int term;
    private String medicalhistory;
   

    public HealthInsurance(String holdername, int spanassured, String nomiee, int premium, int policyperiod, int term,
            String medicalhistory) {
        this.holdername = holdername;
        this.spanassured = spanassured;
        this.nomiee = nomiee;
        this.premium = premium;
        this.policyperiod = policyperiod;
        this.term = term;
        this.medicalhistory = medicalhistory;
    }


    public String getHoldername() {
        return holdername;
    }


    public int getSpanassured() {
        return spanassured;
    }


    public String getNomiee() {
        return nomiee;
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


    public String getMedicalhistory() {
        return medicalhistory;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }


    @Override
    public String toString() {
        return "HealthInsurance [holdername=" + holdername + ", spanassured=" + spanassured + ", nomiee=" + nomiee
                + ", premium=" + premium + ", policyperiod=" + policyperiod + ", term=" + term + ", medicalhistory="
                + medicalhistory + "]";
    }
}
