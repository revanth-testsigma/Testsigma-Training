class Testcase2 extends Testcase{
    @Override
    public String run(int num) throws err{
        String resp = "0";
        try{
        if (num < 5) {
            throw new err("Test case 2 failed : Must be a greater than 5.");
        }else{
            resp = "Test case 2 passed.";
            System.out.println(resp);
        }
    }catch(err e){
        System.out.println(e.getMessage());
    }
        return resp;
    }
}
