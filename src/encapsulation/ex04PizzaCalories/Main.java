package encapsulation.ex04PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaInfo = scanner.nextLine().split("\\s+");
        String pizzaName = pizzaInfo[1];
        int numberOfToppings = Integer.parseInt(pizzaInfo[2]);

        Pizza pizza = null;

        try {
             pizza = new Pizza(pizzaName, numberOfToppings);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String[] doughInfo = scanner.nextLine().split("\\s+");

        String type = doughInfo[1];
        String bakingTechnique = doughInfo[2];
        double weight = Double.parseDouble(doughInfo[3]);

        try {
            Dough dough = new Dough(type, bakingTechnique, weight);
            pizza.setDough(dough);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String toppings = scanner.nextLine();

        while (!toppings.equals("END")) {
            String[] toppingInformation = toppings.split("\\s+");

            String toppingType = toppingInformation[1];
            double toppingWeight = Double.parseDouble(toppingInformation[2]);

            try {
                Topping topping = new Topping(toppingType, toppingWeight);
                pizza.addTopping(topping);

            } catch (IllegalArgumentException e ) {
                System.out.println(e.getMessage());
                return;
            }

            toppings = scanner.nextLine();
        }

        System.out.println(pizza.toString());

    }
}
//Pizza Bulgarian 2
//Dough White Chewy 100
//Topping Parmesan 50
//Topping Cheese 50
//Topping Salami 20
//Topping Meat 10
//END

//Pizza Bulgarian 2
//Dough Type500 Bulgarian 100
//Topping Cheese 50
//Topping Cheese 50
//Topping Salami 20
//Topping Meat 10
//END

//Pizza Bulgarian 20
//Dough Type500 Bulgarian 100
//Topping Cheese 50
//Topping Cheese 50
//Topping Salami 20
//Topping Meat 10
//END

//Pizza Meatless 2
//Dough Wholegrain Crispy 100
//Topping Veggies 50
//Topping Cheese 50
//END