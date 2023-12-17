package SOLID.logger.appenders;

import SOLID.logger.enums.ReportLevel;
import SOLID.logger.interfaces.Layout;

public class ConsoleAppender extends CustomAppender {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void appendMessage(String dateAndTime, String message, ReportLevel reportLevel) {

        if(appendCheck(reportLevel)) {
            String formattedMessage = super.getLayout().formatMessage(dateAndTime, reportLevel, message);
            increaseReportCounter();
            System.out.print(formattedMessage);
        }

    }


}
