package encapsulation.ex04PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        validateTopping(toppingType);
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {

        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        String top = this.toppingType.toUpperCase();

        return 2 * this.weight * ToppingModifiers.valueOf(top).getModifier();
    }

    private void validateTopping(String toppingType) {
        if (!toppingType.equals("Meat")
            && !toppingType.equals("Veggies")
            && !toppingType.equals("Cheese")
            && !toppingType.equals("Sauce"))  {

            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
    }

}
