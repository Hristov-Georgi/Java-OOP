package encapsulation.ex04PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setWeight(double weight) {

        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }

        this.weight = weight;
    }

    private void setFlourType(String flourType) {

        if (flourType.equals("White") || flourType.equals("Wholegrain")) {
            this.flourType = flourType;
            return;
        }

        throw new IllegalArgumentException("Invalid type of dough.");
    }

    private void setBakingTechnique(String bakingTechnique) {

        if (bakingTechnique.equals("Crispy") || bakingTechnique.equals("Chewy") || bakingTechnique.equals("Homemade")) {
            this.bakingTechnique = bakingTechnique;
            return;
        }

        throw new IllegalArgumentException("Invalid type of dough.");

    }

    public double calculateCalories() {
        double doughModifier = DoughModifiers.valueOf(this.flourType.toUpperCase()).getModifier();
        double bakingModifier = DoughModifiers.valueOf(this.bakingTechnique.toUpperCase()).getModifier();

        return 2 * this.weight * doughModifier * bakingModifier;
    }






}
