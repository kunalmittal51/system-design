package loggersystem.logprocessor;

import loggersystem.enums.LogLevel;

public class ErrorLogProcessor extends LogProcessor {

    public ErrorLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void log(LogLevel logLevel, String log) {
        if (LogLevel.ERROR.equals(logLevel)) {
            System.out.println("INFO: " + log);
        } else {
            super.log(logLevel, log);
        }
    }
}
