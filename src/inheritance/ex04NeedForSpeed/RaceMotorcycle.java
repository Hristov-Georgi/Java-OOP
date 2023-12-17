package inheritance.ex04NeedForSpeed;

public class RaceMotorcycle extends Motorcycle {
    private static final double DEFAULT_FUEL_CONSUMPTION = 8;

    public RaceMotorcycle(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setDefaultFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
