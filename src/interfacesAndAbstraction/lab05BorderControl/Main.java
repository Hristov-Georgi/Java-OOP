package interfacesAndAbstraction.lab05BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> identifiableList = new ArrayList<>();

        String input = scanner.nextLine();

        while(!input.equals("End")) {

            String[] information = input.split("\\s+");

            if (information.length == 2) {
                String model = information[0];
                String id = information[1];

                Robot robot = new Robot(model, id);
                identifiableList.add(robot);

            } else {
                String name = information[0];
                int age = Integer.parseInt(information[1]);
                String id = information[2];

                Citizen citizen = new Citizen(name, age, id);
                identifiableList.add(citizen);
            }

            input = scanner.nextLine();
        }

        String lastDigitsFakeId = scanner.nextLine();

        System.out.println(identifiableList.stream()
                .map(Identifiable::getId)
                .filter(id -> id.endsWith(lastDigitsFakeId))
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
