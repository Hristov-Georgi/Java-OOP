package exceptionsAndErrorHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lab03EnterNumbers {
    public static void main(String[] args) {

        List<String> validNumbers = new ArrayList<>(10);

        readNumber(validNumbers);

        System.out.println(String.join(", ", validNumbers));

    }

    private static void readNumber(List<String> validNumbers) {
        Scanner scanner = new Scanner(System.in);

        int counter = 0;

        while (counter < 10) {

            String num = scanner.nextLine();

            try {
                isNumberInRange(num, validNumbers);
                counter++;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

            }

        }

    }

    private static int isValidNumber(String number) {

        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException("Invalid Number!");
        }

    }

    private static void isNumberInRange(String number, List<String> numbers) {

        int num = isValidNumber(number);

        int lastEnteredNum = 1;

        if (numbers.size() > 0) {
             lastEnteredNum = Integer.parseInt(numbers.get(numbers.size() - 1));
        }

        if (num <= 1 || num >= 100 || num <= lastEnteredNum) {

            throw new IllegalArgumentException("Your number is not in range " + lastEnteredNum + " - 100!");
        }

        numbers.add(number);
    }
}
