import java.util.Scanner;
enum Vcategory {
    BUS,
    TRAIN,
    FLIGHT
}
enum Tvendor{
    BUS_VENDOR1,
    BUS_VENDOR2,
    BUS_VENDOR3,
    TRAIN_VENDOR1,
    TRAIN_VENDOR2,
    TRAIN_VENDOR3,
    FLIGHT_VENDOR1,
    FLIGHT_VENDOR2,
    FLIGHT_VENDOR3
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Select category (Bus/Train/Flight): ");
        String categoryInput = scanner.nextLine().toUpperCase();

        Vcategory category;
        try {
            category = Vcategory.valueOf(categoryInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid category.");
            return;
        }

        System.out.print("Select Vendor: ");
        Tvendor[] vendors = Tvendor.values();
        for (Tvendor vendor : vendors) {
            if (vendor.toString().contains(categoryInput)){
            System.out.println(vendor);
        }
        }
        String vendorInput = scanner.nextLine().toUpperCase();

        Tvendor vendor;
        try {
            vendor = Tvendor.valueOf(vendorInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid vendor.");
            return;
        }

        System.out.print("Enter Distance (in km): ");
        double distance = scanner.nextDouble();

        double totalFare = Counter.calculateTotalFare(category, vendor, distance);
        System.out.println("Total Fare: " + totalFare);
        scanner.close();
    }
}
