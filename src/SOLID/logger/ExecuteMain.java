package SOLID.logger;

import SOLID.logger.enums.ReportLevel;
import SOLID.logger.factories.LoggerFactory;
import SOLID.logger.interfaces.Logger;

import java.util.Scanner;

public class ExecuteMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ParseInput parseInput = new ParseInput();

        LoggerFactory loggerFactory = new LoggerFactory();
        Logger logger = loggerFactory.produce(parseInput.readInputInformation(scanner));

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split("\\|");

            ReportLevel reportLevel = ReportLevel.valueOf(tokens[0]);
            String timeAndDate = tokens[1];
            String message = tokens[2];

            switch (reportLevel) {

                case INFO:
                    logger.logInfo(timeAndDate, message);
                        break;

                case ERROR:
                    logger.logError(timeAndDate, message);
                    break;

                case FATAL:
                    logger.logFatal(timeAndDate, message);
                    break;

                case WARNING:
                    logger.logWarning(timeAndDate, message);
                    break;

                case CRITICAL:
                    logger.logCritical(timeAndDate, message);
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(logger);

    }

}
