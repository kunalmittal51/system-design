package loggersystem.logprocessor;

import loggersystem.enums.LogLevel;

public class InfoLogProcessor extends LogProcessor {

    public InfoLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void log(LogLevel logLevel, String log) {
        if (LogLevel.INFO.equals(logLevel)) {
            System.out.println("INFO: " + log);
        } else {
            super.log(logLevel, log);
        }
    }
}
