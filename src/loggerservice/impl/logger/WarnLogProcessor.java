package loggerservice.impl.logger;

import loggerservice.enums.LogLevel;
import loggerservice.enums.SinkType;
import loggerservice.impl.LoggerConfigService;

import java.time.LocalDateTime;

public class WarnLogProcessor extends LogProcessor {
    public WarnLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    public void log(LogLevel logLevel, String message, String namespace, LoggerConfigService loggerConfigService) {
        if (logLevel == LogLevel.WARN) {
            SinkType sinkType =  loggerConfigService.getSinkType(logLevel);
            System.out.println(sinkType +  "  WARN: " + message + " " + namespace + " " + LocalDateTime.now());
        } else if (!loggerConfigService.getLogLevel().equals(LogLevel.WARN)) {
            super.log(logLevel, message, namespace, loggerConfigService);
        }
    }
}
