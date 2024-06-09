package loggersystem.logprocessor;

import loggersystem.enums.LogLevel;

import java.util.Objects;

public class LogProcessor {

    LogProcessor nextProcessor;

    public LogProcessor(LogProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public void log(LogLevel logLevel, String message) {
        if (Objects.nonNull(nextProcessor)) {
            nextProcessor.log(logLevel, message);
        }
    }
}
