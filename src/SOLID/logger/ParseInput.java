package SOLID.logger;

import java.util.Scanner;

public class ParseInput {

    public String readInputInformation(Scanner scanner) {

        int lines = Integer.parseInt(scanner.nextLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < lines ; i++) {

            sb.append(scanner.nextLine())
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }
}
