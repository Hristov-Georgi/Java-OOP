package SOLID.logger.layouts;

import SOLID.logger.enums.ReportLevel;
import SOLID.logger.interfaces.Layout;

public class XmlLayout implements Layout {


    @Override
    public String formatMessage(String dateAndTime, ReportLevel reportLevel, String message) {
        return String.format("<log>%n   <date>%s</date>%n   <level>%s</level>%n   <message>%s</message>%n</log>%n",
                dateAndTime, reportLevel, message);
    }
}
