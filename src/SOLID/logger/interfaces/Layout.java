package SOLID.logger.interfaces;

import SOLID.logger.enums.ReportLevel;

public interface Layout {

    String formatMessage(String dateAndTime, ReportLevel reportLevel, String message);
}
