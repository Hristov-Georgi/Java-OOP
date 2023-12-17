package abstraction.lab04HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(input[0]);
        int numberOfDays = Integer.parseInt(input[1]);
        String season = input[2];
        String discountType = input[3];

        PriceCalculator priceCalculator =
                new PriceCalculator(pricePerDay, numberOfDays,
                        DiscountType.discount(discountType), Season.season(season));

        System.out.printf("%.2f", priceCalculator.priceOfHoliday());



    }
}


