package polymorphism.ex01Vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    private static final double FUEL_CONSUMPTION_WORKING_AC = 1.6;
    private static final double REFUEL_PERCENTAGE = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    protected void refuel(double fuelLitres) {
        setFuelQuantity(getFuelQuantity() + fuelLitres * REFUEL_PERCENTAGE);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + FUEL_CONSUMPTION_WORKING_AC);
    }


}
