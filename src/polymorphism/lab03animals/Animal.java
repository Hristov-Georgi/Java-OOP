package polymorphism.lab03animals;

public abstract class Animal {
    private String name;
    private String favouriteFood;

    public Animal(String name, String favouriteFood){
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    public abstract String explainSelf();

    public String animalSays() {
        return String.format("I am %s and my favourite food is %s%n", this.name, this.favouriteFood);

    }

}
