public class Bike implements Vehicle{
    @Override
    public void start() {
        System.out.println("Bike started.");
    }
    @Override
    public void horn(){
        System.out.println("Bike horn.");
    }
    @Override
    public void stop() {
        System.out.println("Bike stopped.");
    } 
}
