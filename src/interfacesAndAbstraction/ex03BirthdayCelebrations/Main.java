package interfacesAndAbstraction.ex03BirthdayCelebrations;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> birthDaysList = new ArrayList<>();

        String input = scanner.nextLine();

        while(!input.equals("End")) {

            String[] inputData = input.split("\\s+");
            String className = inputData[0];

            switch (className) {

                case "Citizen":
                    String name = inputData[1];
                    int age = Integer.parseInt(inputData[2]);
                    String id = inputData[3];
                    String birthDate = inputData[4];

                    Citizen citizen = new Citizen(name, age, id, birthDate);
                    birthDaysList.add(citizen);

                    break;

                case "Pet":

                    String petName = inputData[1];
                    String petBirthDate = inputData[2];

                    Pet pet = new Pet(petName, petBirthDate);
                    birthDaysList.add(pet);

                    break;

                case "Robot":

                    String model = inputData[1];
                    String robotId = inputData[2];

                    Robot robot = new Robot(robotId, model);

                    break;

            }

            input = scanner.nextLine();
        }

        String yearToCompare = scanner.nextLine();

        List<String> validDates = birthDaysList.stream()
                .map(Birthable::getBirthDate)
                .filter(date -> date.endsWith(yearToCompare))
                .collect(Collectors.toList());

        if (validDates.isEmpty()) {
            System.out.println("<no output>");

        } else {

            for (String date : validDates) {
                System.out.println(date);
            }
        }

    }
}
