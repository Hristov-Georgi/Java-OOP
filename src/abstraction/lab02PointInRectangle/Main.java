package abstraction.lab02PointInRectangle;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] points = readCoordinates(scanner);

        int xB = points[2];
        int yB = points[3];
        int xC = points[0];
        int yC = points[1];

        Rectangle rectangle = new Rectangle(new Point(xB, yB), new Point(xC, yC));

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            int[] point = readCoordinates(scanner);

            Point pointToCheck = new Point(point[0], point[1]);

            System.out.println(rectangle.contains(pointToCheck));

        }

    }

    private static int[] readCoordinates (Scanner scanner) {

        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }


}
