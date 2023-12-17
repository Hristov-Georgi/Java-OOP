package inheritance.ex04NeedForSpeed;

public class Car extends Vehicle {
    private final static double DEFAULT_FUEL_CONSUMPTION = 3;

    public Car(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setDefaultFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }


}
