package loggerservice.impl.logger;

import loggerservice.enums.LogLevel;
import loggerservice.impl.LoggerConfigService;

public class LogProcessor {

    LogProcessor nextProcessor;

    public LogProcessor(LogProcessor logProcessor) {
        this.nextProcessor = logProcessor;
    }

    public void log(LogLevel logLevel, String message, String nameSpace, LoggerConfigService loggerConfigService) {
        if (this.nextProcessor != null) {
            this.nextProcessor.log(logLevel, message, nameSpace, loggerConfigService);
        }
    }
}
