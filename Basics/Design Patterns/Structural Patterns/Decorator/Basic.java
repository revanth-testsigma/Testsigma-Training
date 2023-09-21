public class Basic implements Pizza{
    
    @Override 
    public double getCost(){
        return 150.0;
    }
    @Override 
    public String getDescription(){
        return "Basic Pizza";
    }

}
