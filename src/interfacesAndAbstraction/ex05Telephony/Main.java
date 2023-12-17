package interfacesAndAbstraction.ex05Telephony;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] phoneNumbers = scanner.nextLine().split("\\s+");
        String[] sites = scanner.nextLine().split("\\s+");

        Smartphone smartphone = new Smartphone(List.of(phoneNumbers), List.of(sites) );

        System.out.print(smartphone.call());
        System.out.print(smartphone.browse());

    }
}


