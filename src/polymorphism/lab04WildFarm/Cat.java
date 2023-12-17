package polymorphism.lab04WildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalType, String animalName,Double animalWeight, String livingRegion, String breed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    protected void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        DecimalFormat formatWeight = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]", super.getAnimalType(), super.getAnimalName(), this.breed,
                formatWeight.format(super.getAnimalWeight()), super.getLivingRegion(), super.getFoodEaten() );
    }

}
