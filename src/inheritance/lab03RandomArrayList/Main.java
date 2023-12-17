package inheritance.lab03RandomArrayList;

public class Main {
    public static void main(String[] args) {

        RandomArrayList<Double> randomArrayList = new RandomArrayList<>();

        double number = 0.3;

        for (int i = 0; i < 21; i++) {

           randomArrayList.add(number);
           number += 0.7;
        }

        System.out.println(randomArrayList.getRandomElement());

    }
}
