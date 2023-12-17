package interfacesAndAbstraction.ex04FoodShortage;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Buyer> buyersMap = new HashMap<>();

        int N = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < N; i++) {
            String[] inputData = scanner.nextLine().split("\\s+");

            if (inputData.length == 3) {
                String rebelName = inputData[0];
                int rebelAge = Integer.parseInt(inputData[1]);
                String group = inputData[2];

                Buyer rebel = new Rebel(rebelName, rebelAge, group);
                buyersMap.put(rebelName, rebel);

            } else {

                String citizenName = inputData[0];
                int age = Integer.parseInt(inputData[1]);
                String id = inputData[2];
                String birthDate = inputData[3];

                Buyer citizen = new Citizen(citizenName, age, id, birthDate);
                buyersMap.put(citizenName, citizen);

            }

        }

        String name = scanner.nextLine();

        while(!name.equals("End")) {

            if(buyersMap.containsKey(name)) {
                buyersMap.get(name).buyFood();
            }

            name = scanner.nextLine();
        }

        int totalFood = 0;

        for(Buyer p : buyersMap.values()) {
            totalFood += p.getFood();
        }

        System.out.println(totalFood);
    }
}
