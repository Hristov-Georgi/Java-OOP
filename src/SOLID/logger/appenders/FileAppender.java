package SOLID.logger.appenders;

import SOLID.logger.enums.ReportLevel;
import SOLID.logger.interfaces.File;
import SOLID.logger.interfaces.Layout;

public class FileAppender extends CustomAppender {
    private File file;

    public FileAppender(Layout layout) {
        super(layout);
        this.file = new LogFile();
    }

    public FileAppender(Layout layout, String fileName) {
        this(layout);
        this.file = new LogFile(fileName);
    }

    @Override
    public void appendMessage(String dateAndTime, String message, ReportLevel reportLevel) {

        if(appendCheck(reportLevel)) {
            String outputFormat = super.getLayout().formatMessage(dateAndTime, reportLevel, message);
            increaseReportCounter();
            this.file.append(outputFormat);
        }
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return super.toString() + ", File size: " + this.file.getSize();
    }
}
