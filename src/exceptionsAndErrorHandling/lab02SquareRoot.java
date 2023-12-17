package exceptionsAndErrorHandling;

import java.util.Scanner;

public class lab02SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();

        try {
            int num = Integer.parseInt(number);

            isNumberInRange(num);

            System.out.printf("%.2f%n", Math.sqrt(num));
        } catch (IllegalArgumentException ex) {
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }
    }

    private static void isNumberInRange(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
    }
}
