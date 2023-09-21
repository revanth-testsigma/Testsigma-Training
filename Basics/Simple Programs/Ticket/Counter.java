public class Counter {
    public static double calculateTotalFare(Vcategory category, Tvendor vendor, double distance) {
        double farePerKm = Fare.getFare(category, vendor);
        return farePerKm * distance;
    }
}
