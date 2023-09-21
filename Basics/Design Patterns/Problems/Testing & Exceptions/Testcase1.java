class Testcase1 extends Testcase{
    @Override
    public String run(int num) throws err{
        String resp = "0";
        try{
            if (num < 0) {
                throw new err("Test case 1 failed : Must be a positive integer.");
            }else{
                resp = "Test case 1 passed.";
                System.out.println(resp);
            }
        }catch(err e){
            System.out.println(e.getMessage());
        }
        return resp;
    }
}
