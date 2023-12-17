package SOLID.logger.factories;

import SOLID.logger.appenders.ConsoleAppender;
import SOLID.logger.appenders.FileAppender;
import SOLID.logger.enums.ReportLevel;
import SOLID.logger.interfaces.Appender;
import SOLID.logger.interfaces.Factory;
import SOLID.logger.interfaces.Layout;

public class AppenderFactory implements Factory<Appender> {

    private LayoutFactory layoutFactory;

    public AppenderFactory() {
        this.layoutFactory = new LayoutFactory();
    }

    @Override
    public Appender produce(String inputData) {

        String[] input = inputData.split("\\s+");

        String appenderType = input[0];
        String layoutType = input[1];

        Layout layout = layoutFactory.produce(layoutType);

        Appender appender = null;

        if (appenderType.equals("ConsoleAppender")) {
            appender = new ConsoleAppender(layout);
        } else if (appenderType.equals("FileAppender")) {
            appender = new FileAppender(layout);
        }

        if (input.length == 3) {
            appender.setReportLevel(ReportLevel.valueOf(input[2]));
        }

        return appender;
    }
}
