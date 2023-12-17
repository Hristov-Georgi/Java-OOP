package polymorphism.ex01Vehicles;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> vehiclesMap = new LinkedHashMap<>();

        String[] inputInformation = scanner.nextLine().split("\\s+");
        String vehicleType = inputInformation[0];

        vehiclesMap.put(vehicleType, createCar(inputInformation));

        inputInformation = scanner.nextLine().split("\\s+");
        String type = inputInformation[0];

        vehiclesMap.put(type, createTruck(inputInformation));

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            String vehicle = input[1];

            switch (command) {
                case "Drive" :
                    double distance = Double.parseDouble(input[2]);

                    System.out.println(vehiclesMap.get(vehicle).driving(distance));

                    break;

                case "Refuel":
                    double fuelAmount = Double.parseDouble(input[2]);

                    vehiclesMap.get(vehicle).refuel(fuelAmount);

                    break;
            }

        }

        for (Map.Entry<String, Vehicle> v : vehiclesMap.entrySet()) {
            System.out.printf("%s: %.2f%n", v.getKey(), v.getValue().getFuelQuantity());
        }

    }

    private static Vehicle createCar(String[] inputInformation) {
        double fuelQuantity = Double.parseDouble(inputInformation[1]);
        double fuelConsumption = Double.parseDouble(inputInformation[2]);

        return new Car(fuelQuantity, fuelConsumption);
    }

    private static Vehicle createTruck(String[] inputInformation) {
        double fuelQuantity = Double.parseDouble(inputInformation[1]);
        double fuelConsumption = Double.parseDouble(inputInformation[2]);

        return new Truck(fuelQuantity, fuelConsumption);
    }

}
