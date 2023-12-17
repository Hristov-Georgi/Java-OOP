package polymorphism.ex02VehiclesExtension;

public class Bus extends Vehicle {
    private static final double FUEL_CONSUMPTION_WITH_PEOPLE_WORKING_AC = 1.4;
    private boolean isEmpty;


    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.isEmpty = false;
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        if(isEmpty) {
            super.setFuelConsumption(fuelConsumption);
        }

        super.setFuelConsumption(fuelConsumption + FUEL_CONSUMPTION_WITH_PEOPLE_WORKING_AC);
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}
