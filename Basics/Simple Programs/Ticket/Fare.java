import java.util.HashMap;
import java.util.Map;

public class Fare {
    private static final Map<Tvendor, Double> busFares = new HashMap<>();
    private static final Map<Tvendor, Double> trainFares = new HashMap<>();
    private static final Map<Tvendor, Double> flightFares = new HashMap<>();

    static {
        // Bus fares
        busFares.put(Tvendor.BUS_VENDOR1, 100.0);
        busFares.put(Tvendor.BUS_VENDOR2, 100.0 * 1.02);
        busFares.put(Tvendor.BUS_VENDOR3, 100.0 * 1.04);

        // Train fares
        trainFares.put(Tvendor.TRAIN_VENDOR1, 50.0);
        trainFares.put(Tvendor.TRAIN_VENDOR2, 50.0 * 1.05);
        trainFares.put(Tvendor.TRAIN_VENDOR3, 50.0 * 1.1);

        // Flight fares
        flightFares.put(Tvendor.FLIGHT_VENDOR1, 500.0);
        flightFares.put(Tvendor.FLIGHT_VENDOR2, 500.0 * 1.08);
        flightFares.put(Tvendor.FLIGHT_VENDOR3, 500.0 * 1.16);
    }

    public static double getFare(Vcategory category, Tvendor vendor) {
        switch (category) {
            case BUS:
                return busFares.get(vendor);
            case TRAIN:
                return trainFares.get(vendor);
            case FLIGHT:
                return flightFares.get(vendor);
            default:
                return 0.0;
        }
    }
}
