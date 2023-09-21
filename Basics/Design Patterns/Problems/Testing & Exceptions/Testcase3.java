class Testcase3 extends Testcase{
    @Override
    public String run(int num) throws err{
        String resp = "0";
        try{
        if (num > 1000) {

            throw new err("Test case 3 failed : Must be a less than 1000.");
        }else{
            resp = "Test case 3 passed.";
            System.out.println(resp);
        }
    }catch(err e){
        System.out.println(e.getMessage());
    }
        return resp;
    }
}
