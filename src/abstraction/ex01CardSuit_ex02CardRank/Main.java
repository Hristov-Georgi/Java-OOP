package abstraction.ex01CardSuit_ex02CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        switch (input) {
            case "Card Suits":
                System.out.println("Card Suits:");

                for (CardSuits cardSuits : CardSuits.values()) {
                    System.out.printf("Ordinal value: %d; Name value: %s%n", cardSuits.ordinal(), cardSuits.name());
                }

                break;

            case "Card Ranks":
                System.out.println("Card Ranks:");

                for (CardRank cardRank : CardRank.values()) {
                    System.out.printf("Ordinal value: %d; Name value: %s%n", cardRank.ordinal(), cardRank.name());

                }

                break;
        }

    }
}
