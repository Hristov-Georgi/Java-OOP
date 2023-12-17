package abstraction.ex05JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int N = dimensions[0];
        int M = dimensions[1];

        int[][] battleField = new int[N][M];

        fillBattleField(battleField);

        String command = scanner.nextLine();

        long starsSum = 0;

        while (!command.equals("Let the Force be with you")) {

            int[] jediStart = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();

            int[] evilStart = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int nEvil = evilStart[0];
            int mEvil = evilStart[1];

            while (nEvil >= 0 && mEvil >= 0) {
                if (nEvil < battleField.length && mEvil < M) {
                    battleField[nEvil][mEvil] = 0;
                }
                nEvil--;
                mEvil--;
            }

            int nJedi = jediStart[0];
            int mJedi = jediStart[1];

            while (nJedi >= 0 && mJedi < M) {
                if (nJedi < battleField.length && mJedi >= 0 ) {
                    starsSum += battleField[nJedi][mJedi];
                }

                mJedi++;
                nJedi--;
            }

            command = scanner.nextLine();
        }

        System.out.println(starsSum);


    }

    private static void fillBattleField (int[][] matrix) {
        int value = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = value++;
            }
        }
    }
}
