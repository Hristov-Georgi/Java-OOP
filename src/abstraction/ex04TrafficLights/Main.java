package abstraction.ex04TrafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LightColor[] lightColor = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(LightColor::valueOf).toArray(LightColor[]::new);

        List<TrafficLight> trafficLights = new ArrayList<>();

        for (LightColor color : lightColor) {
            TrafficLight trafficLight = new TrafficLight(color);
            trafficLights.add(trafficLight);

        }

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            for (TrafficLight light : trafficLights) {
                light.changeColor();
                System.out.print(light + " ");
            }

            System.out.println();

        }

    }
}
