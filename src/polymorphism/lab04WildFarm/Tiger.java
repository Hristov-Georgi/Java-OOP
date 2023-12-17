package polymorphism.lab04WildFarm;

public class Tiger extends Felime {

    public Tiger(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    protected void eat(Food food) {
        if(food instanceof Vegetable) {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }

        super.eat(food);
    }

    @Override
    protected void makeSound() {
        System.out.println("ROAAR!!!");
    }
}
