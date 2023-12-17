package polymorphism.ex02VehiclesExtension;


public class Car extends Vehicle {
    private static final double FUEL_CONSUMPTION_WORKING_AC = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + FUEL_CONSUMPTION_WORKING_AC);
    }




}
