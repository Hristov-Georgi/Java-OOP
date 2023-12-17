package SOLID.logger.interfaces;

import SOLID.logger.enums.ReportLevel;

public interface Appender {

    void appendMessage(String dateAndTime, String message, ReportLevel reportLevel);
    void setReportLevel(ReportLevel reportLevel);
}
