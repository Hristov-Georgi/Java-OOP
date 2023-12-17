package SOLID.logger;

import SOLID.logger.enums.ReportLevel;
import SOLID.logger.interfaces.Appender;
import SOLID.logger.interfaces.Logger;

public class MessageLogger implements Logger {
    private Appender[] appendersArr;

    public MessageLogger(Appender... appenders) {
        this.appendersArr = appenders;
    }

    @Override
    public void logInfo(String dateAndTime, String message) {
        logMessage(dateAndTime, message, ReportLevel.INFO);
    }

    @Override
    public void logWarning(String dateAndTime, String message) {
        logMessage(dateAndTime, message, ReportLevel.WARNING);
    }

    @Override
    public void logError(String dateAndTime, String message) {
        logMessage(dateAndTime, message, ReportLevel.ERROR);
    }

    @Override
    public void logCritical(String dateAndTime, String message) {
        logMessage(dateAndTime, message, ReportLevel.CRITICAL);
    }

    @Override
    public void logFatal(String dateAndTime, String message) {
        logMessage(dateAndTime, message, ReportLevel.FATAL);
    }

    private void logMessage(String dateAndTime, String message, ReportLevel reportLevel) {
        for (Appender appender : appendersArr) {
            appender.appendMessage(dateAndTime, message, reportLevel);
        }
    }

    @Override
    public String toString() {

        StringBuilder printSb = new StringBuilder();
        printSb.append("Logger info").append(System.lineSeparator());

        for (Appender appender : appendersArr) {
            printSb.append(appender.toString());
            printSb.append(System.lineSeparator());
        }

        return printSb.toString();
    }
}
