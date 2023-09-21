import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws err {
        int num = -1;
        //interface variable = new class implementing interface
        System.out.println("\t----- Starting Testplan 1 -----");
        Testplan Testplan1 = new Testplan(num);
        System.out.println("----- Testsuite 1 -----");
        Testsuite Testsuite1 = Testplan1.Testsuite1();
        
        System.out.println("----- Testsuite 2 -----");
        Testsuite Testsuite2 = Testplan1.Testsuite2();

        System.out.println("----- Testsuite 3 -----");
        Testsuite Testsuite3 = Testplan1.Testsuite3();

        // checking failure
            List<Integer> resps = Arrays.asList(Testsuite1.getResult(),Testsuite2.getResult(),Testsuite3.getResult());
            float fail = Collections.frequency(resps, 0);
            try{
                if((1-(fail/(resps.size()))) < 0.75){
                    throw new err("\t------Testplan 1 failed.-------");
                }else{
                    System.out.println("\t-------Testplan 1 passed.-------");
                }
            }catch(err e){
                System.out.println(e.getMessage());
            }


        num = 5;
        //interface variable = new class implementing interface
        System.out.println("\t----- Starting Testplan 2 -----");
        Testplan Testplan2 = new Testplan(num);
        System.out.println("----- Testsuite 1 -----");
        Testsuite p2Testsuite1 = Testplan2.Testsuite1();
        
        System.out.println("----- Testsuite 2 -----");
        Testsuite p2Testsuite2 = Testplan2.Testsuite2();

        System.out.println("----- Testsuite 3 -----");
        Testsuite p2Testsuite3 = Testplan2.Testsuite3();

        // checking failure
            resps = Arrays.asList(p2Testsuite1.getResult(),p2Testsuite2.getResult(),p2Testsuite3.getResult());
            fail = Collections.frequency(resps, 0);
            try{
                if((1-(fail/(resps.size()))) < 0.5){
                    throw new err("\t------Testplan 2 failed.-------");
                }else{
                    System.out.println("\t-------Testplan 2 passed.-------");
                }
            }catch(err e){
                System.out.println(e.getMessage());
            }
    }
    }

