package polymorphism.ex02VehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.tankCapacity = tankCapacity;
    }

    protected String driving(double distance) {
        DecimalFormat format = new DecimalFormat("#.##");
        double neededFuel = distance * this.fuelConsumption;

        if(neededFuel > this.fuelQuantity) {
            return String.format("%s needs refueling", getClass().getSimpleName());

        }
            this.fuelQuantity -= neededFuel;
            return String.format("%s travelled %s km", getClass().getSimpleName(), format.format(distance));

    }

    protected void refuel(double fuelLitres) {
        if(fuelLitres <= 0) {
            System.out.println("Fuel must be a positive number");
            return;
        }

        double refuelFuel = this.getFuelQuantity() + fuelLitres;

        if(refuelFuel <= this.tankCapacity) {
            setFuelQuantity(getFuelQuantity() + fuelLitres);
        } else {
            System.out.println("Cannot fit fuel in tank");
        }
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
