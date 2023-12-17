package polymorphism.ex02VehiclesExtension;

public class Truck extends Vehicle {
    private static final double FUEL_CONSUMPTION_WORKING_AC = 1.6;
    private static final double REFUEL_PERCENTAGE = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    protected void refuel(double fuelLitres) {
        super.refuel(fuelLitres * REFUEL_PERCENTAGE);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + FUEL_CONSUMPTION_WORKING_AC);
    }


}
