package SOLID.logger.appenders;

import SOLID.logger.enums.ReportLevel;
import SOLID.logger.interfaces.Appender;
import SOLID.logger.interfaces.Layout;

public abstract class CustomAppender implements Appender {
   private static final ReportLevel DEFAULT_REPORT_LEVEL = ReportLevel.INFO;

    private Layout layout;
    private ReportLevel reportLevel;
    private int reportsCounter;

    public CustomAppender(Layout layout, ReportLevel reportLevel) {
        this.layout = layout;
        this.reportLevel = reportLevel;
        this.reportsCounter = 0;
    }

    public CustomAppender(Layout layout) {
        this(layout, DEFAULT_REPORT_LEVEL);
    }

    public Layout getLayout() {
        return layout;
    }

    protected boolean appendCheck(ReportLevel reportLevel) {
        return this.reportLevel.ordinal() <= reportLevel.ordinal();
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    protected void increaseReportCounter() {
        this.reportsCounter++;
    }

    @Override
    public String toString() {
       return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
               this.getClass().getSimpleName(), this.layout.getClass().getSimpleName(), this.reportLevel, this.reportsCounter);
    }
}
