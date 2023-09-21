public class LifeInsurance implements Policy {
    private String holdername;
    private int lifeassured;
    private String nomiee;
    private int premium;
    private int policyperiod;
    private int term;
    private int deathbenifit;

    public String getHoldername() {
        return holdername;
    }

    public int getLifeassured() {
        return lifeassured;
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

    public int getDeathbenifit() {
        return deathbenifit;
    }

    public LifeInsurance(String holdername, int lifeassured, String nomiee, int premium, int policyperiod, int term,
            int deathbenifit) {
        this.holdername = holdername;
        this.lifeassured = lifeassured;
        this.nomiee = nomiee;
        this.premium = premium;
        this.policyperiod = policyperiod;
        this.term = term;
        this.deathbenifit = deathbenifit;
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "LifeInsurance [holdername=" + holdername + ", lifeassured=" + lifeassured + ", nomiee=" + nomiee
                + ", premium=" + premium + ", policyperiod=" + policyperiod + ", term=" + term + ", deathbenifit="
                + deathbenifit + "]";
    }
}
