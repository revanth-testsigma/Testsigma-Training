class Testcase4 extends Testcase{
    @Override
    public String run(int num) throws err{
        String resp = "0";
        try{
        if (num%2 != 0) {
            throw new err("Test case 4 failed : Must be a Divisible by 2.");
        }else{
            resp = "Test case 4 passed.";
            System.out.println(resp);
        }
    }catch(err e){
        System.out.println(e.getMessage());
    }
        return resp;
    }
}
