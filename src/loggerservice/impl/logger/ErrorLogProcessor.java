package loggerservice.impl.logger;

import loggerservice.enums.LogLevel;
import loggerservice.enums.SinkType;
import loggerservice.impl.LoggerConfigService;

import java.time.LocalDateTime;

public class ErrorLogProcessor extends LogProcessor {

    public ErrorLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    public void log(LogLevel logLevel, String message, String namespace, LoggerConfigService loggerConfigService) {
        if (logLevel == LogLevel.ERROR) {
            SinkType sinkType =  loggerConfigService.getSinkType(logLevel);
            System.out.println(sinkType +  "  ERROR: " + message + " " + namespace + " " + LocalDateTime.now());
        } else if (!loggerConfigService.getLogLevel().equals(LogLevel.ERROR)) {
            super.log(logLevel, message, namespace, loggerConfigService);
        }
    }
}
