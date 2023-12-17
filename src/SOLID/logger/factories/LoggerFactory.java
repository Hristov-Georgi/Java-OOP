package SOLID.logger.factories;

import SOLID.logger.ExecuteMain;
import SOLID.logger.MessageLogger;
import SOLID.logger.appenders.LogFile;
import SOLID.logger.interfaces.Appender;
import SOLID.logger.interfaces.Factory;
import SOLID.logger.interfaces.Logger;

public class LoggerFactory implements Factory<Logger> {

    private AppenderFactory appenderFactory;

    public LoggerFactory() {
        this.appenderFactory = new AppenderFactory();
    }

    @Override
    public Logger produce(String inputData) {

        String[] input = inputData.split(System.lineSeparator());

        Appender[] appenders = new Appender[input.length];

        for (int i = 0; i < appenders.length; i++) {
            appenders[i] = this.appenderFactory.produce(input[i]);

        }

        return new MessageLogger(appenders);

    }
}
