package polymorphism.lab04WildFarm;

public abstract class Animal {

    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;

    public Animal(String animalType, String animalName, Double animalWeight) {
        this.animalType = animalType;
        this.animalName = animalName;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }


    protected abstract void makeSound();

    protected void eat(Food food){
        this.foodEaten += food.getQuantity();
    }

   protected String getAnimalName() {
        return this.animalName;
   }

   protected String getAnimalType() {
        return this.animalType;
   }

   protected Double getAnimalWeight() {
        return this.animalWeight;
   }

   protected Integer getFoodEaten() {
        return this.foodEaten;
   }

}
