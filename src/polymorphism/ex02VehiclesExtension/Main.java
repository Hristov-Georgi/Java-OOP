package polymorphism.ex02VehiclesExtension;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> vehiclesMap = new LinkedHashMap<>();

        String[] inputInformation = scanner.nextLine().split("\\s+");
        String vehicleType = inputInformation[0];

        vehiclesMap.put(vehicleType, createVehicle(inputInformation));

        inputInformation = scanner.nextLine().split("\\s+");
        vehicleType = inputInformation[0];

        vehiclesMap.put(vehicleType, createVehicle(inputInformation));

        inputInformation = scanner.nextLine().split("\\s+");
        vehicleType = inputInformation[0];

        vehiclesMap.put(vehicleType, createVehicle(inputInformation));

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            String vehicle = input[1];

            Vehicle typeOfVehicle = vehiclesMap.get(vehicle);

            switch (command) {
                case "Drive" :
                    double distance = Double.parseDouble(input[2]);

                    if(typeOfVehicle instanceof Bus) {
                        ((Bus) typeOfVehicle).setEmpty(true);
                    }
                    System.out.println(vehiclesMap.get(vehicle).driving(distance));

                    break;

                case "Refuel":
                    double fuelAmount = Double.parseDouble(input[2]);

                    vehiclesMap.get(vehicle).refuel(fuelAmount);

                    break;

                case "DriveEmpty":
                    distance = Double.parseDouble(input[2]);
                    System.out.println(vehiclesMap.get(vehicle).driving(distance));

                    break;
            }

        }

        for (Map.Entry<String, Vehicle> v : vehiclesMap.entrySet()) {
            System.out.printf("%s: %.2f%n", v.getKey(), v.getValue().getFuelQuantity());
        }

    }

    private static Vehicle createVehicle(String[] inputInformation) {
        String vehicleType = inputInformation[0];
        double fuelQuantity = Double.parseDouble(inputInformation[1]);
        double fuelConsumption = Double.parseDouble(inputInformation[2]);
        double tankCapacity = Double.parseDouble(inputInformation[3]);

        switch (vehicleType) {
            case "Car":
                return new Car(fuelQuantity, fuelConsumption, tankCapacity);

            case "Truck":
                return new Truck(fuelQuantity, fuelConsumption, tankCapacity);

            case "Bus":
                return new Bus(fuelQuantity, fuelConsumption, tankCapacity);

            default:
                return null;
        }

    }

}
