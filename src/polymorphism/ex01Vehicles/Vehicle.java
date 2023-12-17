package polymorphism.ex01Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    protected String driving(double distance) {
        DecimalFormat format = new DecimalFormat("#.##");
        double neededFuel = distance * this.fuelConsumption;

        if(neededFuel < this.fuelQuantity) {
            this.fuelQuantity -= neededFuel;
            return String.format("%s travelled %s km", getClass().getSimpleName(), format.format(distance));
        }
        return String.format("%s needs refueling", getClass().getSimpleName());
    }

    protected void refuel(double fuelLitres) {
         setFuelQuantity(getFuelQuantity() + fuelLitres);
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

}
