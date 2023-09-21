public class Main {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();

        // Create a car
        Vehicle car = vehicleFactory.createVehicle("car");
        car.start();
        car.horn();
        car.stop();

        // Create a bike
        Vehicle bike = vehicleFactory.createVehicle("bike");
        bike.start();
        bike.horn();
        bike.stop();
    }
}
