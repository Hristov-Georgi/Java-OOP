package polymorphism.lab04WildFarm;

import java.util.*;

public class ReadConsoleInput {

    protected static void printResult(Scanner scanner) {

        List<Animal> animalsList = new ArrayList<>();

        String firstLineInput = scanner.nextLine();

        while(!firstLineInput.equals("End")) {

            String[] animalInfo = firstLineInput.split("\\s+");

            Animal animal = createAnimal(animalInfo);
            animalsList.add(animal);

            String[] foodInformation  = scanner.nextLine().split("\\s+");

            Food food = createFood(foodInformation);

            animal.makeSound();
            try {
                animal.eat(food);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            firstLineInput = scanner.nextLine();
        }

        for(Animal animal : animalsList) {
            System.out.println(animal.toString());
        }


    }

    private static Food createFood(String[] foodInfo) {

        String foodType = foodInfo[0];
        Integer foodQuantity = Integer.parseInt(foodInfo[1]);

        if(foodType.equals("Vegetable")) {
            return new Vegetable(foodQuantity);
        } else if(foodType.equals("Meat")) {
            return new Meat(foodQuantity);
        }

        return null;
    }

    private static Animal createAnimal(String[] animalInformation) {
        String animalType = animalInformation[0];
        String animalName = animalInformation[1];
        Double animalWeight = Double.parseDouble(animalInformation[2]);
        String animalLivingRegion = animalInformation[3];

        switch(animalType) {

            case "Mouse":
                return new Mouse(animalType, animalName, animalWeight, animalLivingRegion);

            case "Zebra":
                return new Zebra(animalType, animalName, animalWeight, animalLivingRegion);


            case "Cat":
                String breed = animalInformation[4];
                return new Cat(animalType, animalName, animalWeight, animalLivingRegion, breed);

            case "Tiger":
                return new Tiger(animalType, animalName, animalWeight, animalLivingRegion);

        }
        return null;
    }

}
