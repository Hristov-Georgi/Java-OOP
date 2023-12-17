package polymorphism.lab04WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;


    public Mammal(String animalType, String animalName,  Double animalWeight, String livingRegion) {
        super(animalType, animalName,animalWeight);
        this.livingRegion = livingRegion;
    }

    protected String getLivingRegion() {
        return this.livingRegion;
    }


    @Override
    public String toString() {
        DecimalFormat formatWeight = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]", super.getAnimalType(), super.getAnimalName(),
                formatWeight.format(super.getAnimalWeight()), this.livingRegion, super.getFoodEaten() );
    }


}
