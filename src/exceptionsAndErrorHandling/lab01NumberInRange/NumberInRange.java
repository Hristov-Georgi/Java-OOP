package exceptionsAndErrorHandling.lab01NumberInRange;

import java.util.Arrays;
import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.printf("Range: [%d...%d]%n", range[0], range[1]);

        while(true) {

            String number = scanner.nextLine();

            try {
                System.out.println(isNumberInRange(number, range));
                break;

            } catch (NumberFormatException e) {

                System.out.println(e.getMessage());

            }

        }

    }

    private static int isNumber(String number) {

        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException ex){
            throw new NumberFormatException("Invalid number: " + number);

        }
    }

    private static String isNumberInRange(String number, int[] range) {
        int n1 = range[0];
        int n2 = range[1];

        int m = isNumber(number);

        if(m < n1 || m > n2) {
            throw new NumberFormatException("Invalid number: " + m);

        }

        return "Valid number: " + m;
    }
}
