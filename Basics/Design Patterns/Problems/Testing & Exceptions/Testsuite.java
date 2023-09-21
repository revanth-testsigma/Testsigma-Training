import java.util.Arrays;
import java.util.List;
import java.util.Collections;
public class Testsuite {
    private String resp1;
    private String resp2;
    private String resp3;
    private String resp4;
    private double acc;
    
    private int result;
        public void setAcc(double acc) {
        this.acc = acc;
    }

    public int getResult() {
        return result;
    }

    public String getResp1() {
        return resp1;
    }

    public String getResp2() {
        return resp2;
    }

    public String getResp3() {
        return resp3;
    }

    public String getResp4() {
        return resp4;
    }

    // Constructor (private to prevent direct instantiation)
    private Testsuite() {
    }
    
    // Nested Builder class
    public static class Builder {
        private String resp1 = "n";
        private String resp2 = "n";
        private String resp3 = "n";
        private String resp4 = "n";
        
        public Builder T1(int num) throws err{
            Testcase T1 = new Testcase1();
            this.resp1 = T1.run(num); 
            return this;
        }
        public Builder T2(int num) throws err {
            Testcase T2 = new Testcase2();
            this.resp2 = T2.run(num); 
            return this;
        }
        public Builder T3(int num)throws err  {
            Testcase T3 = new Testcase3();
            this.resp3 = T3.run(num); 
            return this;
        }
        public Builder T4(int num) throws err {
            Testcase T4 = new Testcase4();
            this.resp4 = T4.run(num); 
            return this;
        }
        
        
        // Build method to create the Computer instance
        public Testsuite build(double acc) {
            Testsuite testsuite = new Testsuite();
            testsuite.resp1 = this.resp1;
            testsuite.resp2 = this.resp2;
            testsuite.resp3 = this.resp3;
            testsuite.resp4 = this.resp4;
            // checking failure
            List<String> resps = Arrays.asList(this.resp1,this.resp2,this.resp3,this.resp4);
            float fail = Collections.frequency(resps, "0");
            float notu = Collections.frequency(resps, "n");
            try{
                if((1-(fail/(resps.size()-notu))) < acc){
                    testsuite.result = 0;
                    throw new err("Testsuite failed.");
                }else{
                    System.out.println("Testsuite passed.");
                    testsuite.result = 1;
                }
            }catch(err e){
                System.out.println(e.getMessage());
            }

            return testsuite;
        }
    }
}