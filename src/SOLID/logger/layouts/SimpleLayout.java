package SOLID.logger.layouts;

import SOLID.logger.enums.ReportLevel;
import SOLID.logger.interfaces.Layout;

public class SimpleLayout implements Layout {

    @Override
    public String formatMessage(String dateAndTime, ReportLevel reportLevel, String message) {
        return String.format("%s - %s - %s%n", dateAndTime, reportLevel, message);
    }
}
