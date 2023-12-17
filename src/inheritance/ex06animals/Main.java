package inheritance.ex06animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Animal> animalsList = new ArrayList<>();

        String firstLineInput = reader.readLine();
        ValidateInput.validateText(firstLineInput);

        while (!firstLineInput.equals("Beast!")) {

            String[] secondLineInput = reader.readLine().split("\\s+");
            ValidateInput.validateArrayLength(secondLineInput);

            try {
                createAnimal(firstLineInput, secondLineInput, animalsList);

            } catch (IllegalArgumentException e) {

                System.out.println(e.getMessage());
            }

            firstLineInput = reader.readLine();
        }

        for (Animal a : animalsList) {
            System.out.println(a.toString());

        }

    }

    private static void createAnimal(String firstInput, String[] secondInput, List<Animal> animals ) {
        String name = secondInput[0];
        int age = Integer.parseInt(secondInput[1]);
        String gender = secondInput[2];


        switch (firstInput){

            case "Cat":
                Animal cat = new Cat(name, age, gender);
                animals.add(cat);
                break;

            case "Dog":
                Animal dog = new Dog(name,age, gender);
                animals.add(dog);
                break;

            case "Frog":
                Animal frog = new Frog(name, age, gender);
                animals.add(frog);
                break;

        }

    }
}


