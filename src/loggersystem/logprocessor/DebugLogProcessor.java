package loggersystem.logprocessor;

import loggersystem.enums.LogLevel;

public class DebugLogProcessor extends LogProcessor {

    public DebugLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void log(LogLevel logLevel, String log) {
        if (LogLevel.DEBUG.equals(logLevel)) {
            System.out.println("INFO: " + log);
        } else {
            super.log(logLevel, log);
        }
    }
}
