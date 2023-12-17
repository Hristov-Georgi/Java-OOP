package encapsulation.ex04PizzaCalories;

import com.sun.source.util.DocSourcePositions;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppingsList;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);

    }

    private void setToppings(int toppings) {

        if(toppings < 0 || toppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }

        this.toppingsList = new ArrayList<>();
    }

    private void setName(String name) {

        if(name.length() < 1 || name.trim().isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }

        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return this.name;
    }

    public void addTopping(Topping topping) {
        this.toppingsList.add(topping);
    }

    public double getOverallCalories() {
        double toppingTotalCalories = 0;

        for (Topping element : toppingsList) {
            toppingTotalCalories += element.calculateCalories();
        }

        return this.dough.calculateCalories() + toppingTotalCalories;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.name, getOverallCalories());
    }


}
