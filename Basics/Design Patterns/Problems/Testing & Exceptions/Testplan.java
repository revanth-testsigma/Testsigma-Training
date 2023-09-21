public class Testplan{
    private int num;
    public Testplan(int num){
        this.num = num;
    }
    public Testsuite Testsuite1() throws err {
        return new Testsuite.Builder()
                .T1(num).T3(num)
                .build(0.5);
    }
    public Testsuite Testsuite2() throws err {
        return new Testsuite.Builder()
                .T2(num).T4(num)
                .build(0.5);
    }
    public Testsuite Testsuite3() throws err {
        return new Testsuite.Builder()
                .T4(num).T3(num)
                .build(0.5);
    }   
}