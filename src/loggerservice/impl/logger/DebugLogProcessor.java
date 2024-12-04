package loggerservice.impl.logger;

import loggerservice.enums.LogLevel;
import loggerservice.enums.SinkType;
import loggerservice.impl.LoggerConfigService;

import java.time.LocalDateTime;

public class DebugLogProcessor extends LogProcessor {
    public DebugLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    public void log(LogLevel logLevel, String message, String namespace, LoggerConfigService loggerConfigService) {
        if (logLevel == LogLevel.DEBUG) {
            SinkType sinkType =  loggerConfigService.getSinkType(logLevel);
            System.out.println(sinkType +  " DEBUG: " + message + " " + namespace + " " + LocalDateTime.now());
        } else if (!loggerConfigService.getLogLevel().equals(LogLevel.DEBUG)) {
            super.log(logLevel, message, namespace, loggerConfigService);
        }
    }
}
