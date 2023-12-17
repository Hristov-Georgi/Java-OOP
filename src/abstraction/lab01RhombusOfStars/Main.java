package abstraction.lab01RhombusOfStars;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(printTop(n) + printStarsAndMiddle(n) + printBottom(n));
    }

    public static String printStarsAndMiddle(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append("* ");
        }
        return sb.append("\n").toString();
    }

    public static String printWhiteSpace(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public static String printBottom(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {

            sb.append(printWhiteSpace(i));
            sb.append(printStarsAndMiddle(n - i));
        }
        return sb.toString();
    }

    public static String printTop(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            sb.append(printWhiteSpace(n - i));
            sb.append(printStarsAndMiddle(i));
        }
        return sb.toString();
    }
}






